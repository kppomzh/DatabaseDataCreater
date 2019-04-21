package Utils.Factorys;

import dataStructure.RegularClasses.LengthExpression;
import dataStructure.RegularClasses.Regular;
import dataStructure.RegularClasses.SingalMetaChar;

import java.util.ArrayList;

public class getRegularElementsFactory {
    private static getRegularElementsFactory REinstance=new getRegularElementsFactory();
    private ArrayList<Character> regularElements;

    private getRegularElementsFactory(){
        regularElements=new ArrayList<>();
        regularElements.add('d');//数字
        regularElements.add('s');//所有空白字符，这里只考虑空格
        regularElements.add('S');//所有非空白字符
        regularElements.add('w');//字母数字下划线
        regularElements.add('W');//非字母数字下划线
//        regularElements.add('n');//正整数，后续需要检测num
        regularElements.add('z');//中文字符，但是不保证你认识

        regularElements.add('?');//长度为{0,1}
        regularElements.add('+');//长度为{1,}
        regularElements.add('*');//长度为{0,}
    }

    public static getRegularElementsFactory getInstance(){
        return REinstance;
    }

    public boolean checkREle(char element){
        return regularElements.contains(element);
    }

    public Regular makeRegularElement(char element){
        Regular r = null;
        switch (element){
            case 'd':
            case 's':
            case 'S':
            case 'w':
            case 'W':
            case 'n':
            case 'z':
                r=new SingalMetaChar(element);
                break;

            case '?':
                try {
                    r=new LengthExpression(0,1);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            case '+':
                try {
                    r=new LengthExpression(1,null);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            case '*':
                try {
                    r=new LengthExpression(0,null);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        return r;
    }
}
