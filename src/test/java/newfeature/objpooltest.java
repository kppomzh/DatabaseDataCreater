package newfeature;

import Utils.baseEnvironment;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class objpooltest {
    @Ignore
    @Test
    public void objpooltimetest() {
        objpool or = new objpool(4);
        ExecutorService service = Executors.newFixedThreadPool(4);
        long start = System.currentTimeMillis();
        for (int loop = 0; loop < 4; loop++)
            service.execute(new poolrandomMaker(or));
        service.shutdown();
        while (!service.isTerminated()) {
        }
        System.out.println(System.currentTimeMillis() - start);

        or = new objpool();
        service = Executors.newFixedThreadPool(4);
        start = System.currentTimeMillis();
        for (int loop = 0; loop < 4; loop++)
            service.execute(new randomMaker(or));
        service.shutdown();
        while (!service.isTerminated()) {
        }
        System.out.println(System.currentTimeMillis() - start);
    }

}
class objpool {
    /* obj pool */
    public GenericObjectPool<Random> pool;

    public objpool(int poolSize) {
        GenericObjectPoolConfig<Random> conf = new GenericObjectPoolConfig<>();
        conf.setMaxIdle(poolSize);
        conf.setMaxTotal(Integer.valueOf(baseEnvironment.getEnvironment("nCPU")));
        pool = new GenericObjectPool<>(new RandomPooledFactory(), conf);
        for (int i = 0; i < poolSize; i++) {
            try {
                pool.addObject();
            } catch (Exception e) {
                System.exit(-1);
            }
        }
    }

    public BigInteger poolRandomBInteger(){
        BigInteger b = BigInteger.ZERO;
        try {
            pool.getNumIdle();
            Random r = pool.borrowObject();
            b = new BigInteger(200, r);
            pool.returnObject(r);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return b;
    }

    /* obj rdm */
    public Random random;

    public objpool() {
        random = ThreadLocalRandom.current();
    }

    public BigInteger RandomBInteger(){
        return new BigInteger(200,random);
    }
}

class RandomPooledFactory implements PooledObjectFactory<Random> {

    @Override
    public PooledObject<Random> makeObject() {
        return new DefaultPooledObject<>(ThreadLocalRandom.current());
    }

    @Override
    public void destroyObject(PooledObject<Random> pooledObject) {

    }

    @Override
    public boolean validateObject(PooledObject<Random> pooledObject) {
        return true;
    }

    @Override
    public void activateObject(PooledObject<Random> pooledObject) throws Exception {

    }

    @Override
    public void passivateObject(PooledObject<Random> pooledObject) throws Exception {

    }
}

class poolrandomMaker implements Runnable{
    objpool or;

    public poolrandomMaker(objpool o){
        or=o;
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            or.poolRandomBInteger();
        }
    }
}

class randomMaker implements Runnable{
    objpool or;

    public randomMaker(objpool o){
        or=o;
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            or.RandomBInteger();
        }
    }
}