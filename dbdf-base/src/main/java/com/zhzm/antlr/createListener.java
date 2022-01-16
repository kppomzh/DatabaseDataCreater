// Generated from D:/Document/OneDrive/CodeRepo/DatabaseDataCreater/dbdf-base/antlr\create.g4 by ANTLR 4.9.2
package com.zhzm.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link createParser}.
 */
public interface createListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link createParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(createParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(createParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#create}.
	 * @param ctx the parse tree
	 */
	void enterCreate(createParser.CreateContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#create}.
	 * @param ctx the parse tree
	 */
	void exitCreate(createParser.CreateContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#tablecreatebranch}.
	 * @param ctx the parse tree
	 */
	void enterTablecreatebranch(createParser.TablecreatebranchContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#tablecreatebranch}.
	 * @param ctx the parse tree
	 */
	void exitTablecreatebranch(createParser.TablecreatebranchContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#relationproperties}.
	 * @param ctx the parse tree
	 */
	void enterRelationproperties(createParser.RelationpropertiesContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#relationproperties}.
	 * @param ctx the parse tree
	 */
	void exitRelationproperties(createParser.RelationpropertiesContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#column}.
	 * @param ctx the parse tree
	 */
	void enterColumn(createParser.ColumnContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#column}.
	 * @param ctx the parse tree
	 */
	void exitColumn(createParser.ColumnContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#column_options}.
	 * @param ctx the parse tree
	 */
	void enterColumn_options(createParser.Column_optionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#column_options}.
	 * @param ctx the parse tree
	 */
	void exitColumn_options(createParser.Column_optionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#dbdf_options}.
	 * @param ctx the parse tree
	 */
	void enterDbdf_options(createParser.Dbdf_optionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#dbdf_options}.
	 * @param ctx the parse tree
	 */
	void exitDbdf_options(createParser.Dbdf_optionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#hasNull}.
	 * @param ctx the parse tree
	 */
	void enterHasNull(createParser.HasNullContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#hasNull}.
	 * @param ctx the parse tree
	 */
	void exitHasNull(createParser.HasNullContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#tableproperties}.
	 * @param ctx the parse tree
	 */
	void enterTableproperties(createParser.TablepropertiesContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#tableproperties}.
	 * @param ctx the parse tree
	 */
	void exitTableproperties(createParser.TablepropertiesContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#full_tablename}.
	 * @param ctx the parse tree
	 */
	void enterFull_tablename(createParser.Full_tablenameContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#full_tablename}.
	 * @param ctx the parse tree
	 */
	void exitFull_tablename(createParser.Full_tablenameContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#tablespacename}.
	 * @param ctx the parse tree
	 */
	void enterTablespacename(createParser.TablespacenameContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#tablespacename}.
	 * @param ctx the parse tree
	 */
	void exitTablespacename(createParser.TablespacenameContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#tablename}.
	 * @param ctx the parse tree
	 */
	void enterTablename(createParser.TablenameContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#tablename}.
	 * @param ctx the parse tree
	 */
	void exitTablename(createParser.TablenameContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#listname}.
	 * @param ctx the parse tree
	 */
	void enterListname(createParser.ListnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#listname}.
	 * @param ctx the parse tree
	 */
	void exitListname(createParser.ListnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#indexname}.
	 * @param ctx the parse tree
	 */
	void enterIndexname(createParser.IndexnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#indexname}.
	 * @param ctx the parse tree
	 */
	void exitIndexname(createParser.IndexnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#objectName}.
	 * @param ctx the parse tree
	 */
	void enterObjectName(createParser.ObjectNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#objectName}.
	 * @param ctx the parse tree
	 */
	void exitObjectName(createParser.ObjectNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#ranges}.
	 * @param ctx the parse tree
	 */
	void enterRanges(createParser.RangesContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#ranges}.
	 * @param ctx the parse tree
	 */
	void exitRanges(createParser.RangesContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#isnull}.
	 * @param ctx the parse tree
	 */
	void enterIsnull(createParser.IsnullContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#isnull}.
	 * @param ctx the parse tree
	 */
	void exitIsnull(createParser.IsnullContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#not_null}.
	 * @param ctx the parse tree
	 */
	void enterNot_null(createParser.Not_nullContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#not_null}.
	 * @param ctx the parse tree
	 */
	void exitNot_null(createParser.Not_nullContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#inline_constrain}.
	 * @param ctx the parse tree
	 */
	void enterInline_constrain(createParser.Inline_constrainContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#inline_constrain}.
	 * @param ctx the parse tree
	 */
	void exitInline_constrain(createParser.Inline_constrainContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#inline_uniqueKey}.
	 * @param ctx the parse tree
	 */
	void enterInline_uniqueKey(createParser.Inline_uniqueKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#inline_uniqueKey}.
	 * @param ctx the parse tree
	 */
	void exitInline_uniqueKey(createParser.Inline_uniqueKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#inline_primaryKey}.
	 * @param ctx the parse tree
	 */
	void enterInline_primaryKey(createParser.Inline_primaryKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#inline_primaryKey}.
	 * @param ctx the parse tree
	 */
	void exitInline_primaryKey(createParser.Inline_primaryKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#inline_foreignKey}.
	 * @param ctx the parse tree
	 */
	void enterInline_foreignKey(createParser.Inline_foreignKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#inline_foreignKey}.
	 * @param ctx the parse tree
	 */
	void exitInline_foreignKey(createParser.Inline_foreignKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#inline_generalKey}.
	 * @param ctx the parse tree
	 */
	void enterInline_generalKey(createParser.Inline_generalKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#inline_generalKey}.
	 * @param ctx the parse tree
	 */
	void exitInline_generalKey(createParser.Inline_generalKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#inline_checkKey}.
	 * @param ctx the parse tree
	 */
	void enterInline_checkKey(createParser.Inline_checkKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#inline_checkKey}.
	 * @param ctx the parse tree
	 */
	void exitInline_checkKey(createParser.Inline_checkKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#constrain}.
	 * @param ctx the parse tree
	 */
	void enterConstrain(createParser.ConstrainContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#constrain}.
	 * @param ctx the parse tree
	 */
	void exitConstrain(createParser.ConstrainContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#indexType}.
	 * @param ctx the parse tree
	 */
	void enterIndexType(createParser.IndexTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#indexType}.
	 * @param ctx the parse tree
	 */
	void exitIndexType(createParser.IndexTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#general_key}.
	 * @param ctx the parse tree
	 */
	void enterGeneral_key(createParser.General_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#general_key}.
	 * @param ctx the parse tree
	 */
	void exitGeneral_key(createParser.General_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#primary_key}.
	 * @param ctx the parse tree
	 */
	void enterPrimary_key(createParser.Primary_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#primary_key}.
	 * @param ctx the parse tree
	 */
	void exitPrimary_key(createParser.Primary_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#foreign_key}.
	 * @param ctx the parse tree
	 */
	void enterForeign_key(createParser.Foreign_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#foreign_key}.
	 * @param ctx the parse tree
	 */
	void exitForeign_key(createParser.Foreign_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#unique_key}.
	 * @param ctx the parse tree
	 */
	void enterUnique_key(createParser.Unique_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#unique_key}.
	 * @param ctx the parse tree
	 */
	void exitUnique_key(createParser.Unique_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#check_key}.
	 * @param ctx the parse tree
	 */
	void enterCheck_key(createParser.Check_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#check_key}.
	 * @param ctx the parse tree
	 */
	void exitCheck_key(createParser.Check_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#check_key_options}.
	 * @param ctx the parse tree
	 */
	void enterCheck_key_options(createParser.Check_key_optionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#check_key_options}.
	 * @param ctx the parse tree
	 */
	void exitCheck_key_options(createParser.Check_key_optionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#general_key_options}.
	 * @param ctx the parse tree
	 */
	void enterGeneral_key_options(createParser.General_key_optionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#general_key_options}.
	 * @param ctx the parse tree
	 */
	void exitGeneral_key_options(createParser.General_key_optionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#autoincreasing}.
	 * @param ctx the parse tree
	 */
	void enterAutoincreasing(createParser.AutoincreasingContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#autoincreasing}.
	 * @param ctx the parse tree
	 */
	void exitAutoincreasing(createParser.AutoincreasingContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#hasDefault}.
	 * @param ctx the parse tree
	 */
	void enterHasDefault(createParser.HasDefaultContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#hasDefault}.
	 * @param ctx the parse tree
	 */
	void exitHasDefault(createParser.HasDefaultContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#charset}.
	 * @param ctx the parse tree
	 */
	void enterCharset(createParser.CharsetContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#charset}.
	 * @param ctx the parse tree
	 */
	void exitCharset(createParser.CharsetContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#collate}.
	 * @param ctx the parse tree
	 */
	void enterCollate(createParser.CollateContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#collate}.
	 * @param ctx the parse tree
	 */
	void exitCollate(createParser.CollateContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#oracle_tableoption}.
	 * @param ctx the parse tree
	 */
	void enterOracle_tableoption(createParser.Oracle_tableoptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#oracle_tableoption}.
	 * @param ctx the parse tree
	 */
	void exitOracle_tableoption(createParser.Oracle_tableoptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#oracle_tablespaceset}.
	 * @param ctx the parse tree
	 */
	void enterOracle_tablespaceset(createParser.Oracle_tablespacesetContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#oracle_tablespaceset}.
	 * @param ctx the parse tree
	 */
	void exitOracle_tablespaceset(createParser.Oracle_tablespacesetContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#mysql_tableoptions}.
	 * @param ctx the parse tree
	 */
	void enterMysql_tableoptions(createParser.Mysql_tableoptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#mysql_tableoptions}.
	 * @param ctx the parse tree
	 */
	void exitMysql_tableoptions(createParser.Mysql_tableoptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#mysql_tableoption}.
	 * @param ctx the parse tree
	 */
	void enterMysql_tableoption(createParser.Mysql_tableoptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#mysql_tableoption}.
	 * @param ctx the parse tree
	 */
	void exitMysql_tableoption(createParser.Mysql_tableoptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#mysql_engine_set}.
	 * @param ctx the parse tree
	 */
	void enterMysql_engine_set(createParser.Mysql_engine_setContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#mysql_engine_set}.
	 * @param ctx the parse tree
	 */
	void exitMysql_engine_set(createParser.Mysql_engine_setContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#mysql_character_set}.
	 * @param ctx the parse tree
	 */
	void enterMysql_character_set(createParser.Mysql_character_setContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#mysql_character_set}.
	 * @param ctx the parse tree
	 */
	void exitMysql_character_set(createParser.Mysql_character_setContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#mysql_collate}.
	 * @param ctx the parse tree
	 */
	void enterMysql_collate(createParser.Mysql_collateContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#mysql_collate}.
	 * @param ctx the parse tree
	 */
	void exitMysql_collate(createParser.Mysql_collateContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#mysql_rowfomat}.
	 * @param ctx the parse tree
	 */
	void enterMysql_rowfomat(createParser.Mysql_rowfomatContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#mysql_rowfomat}.
	 * @param ctx the parse tree
	 */
	void exitMysql_rowfomat(createParser.Mysql_rowfomatContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#mysql_incrementset}.
	 * @param ctx the parse tree
	 */
	void enterMysql_incrementset(createParser.Mysql_incrementsetContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#mysql_incrementset}.
	 * @param ctx the parse tree
	 */
	void exitMysql_incrementset(createParser.Mysql_incrementsetContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#mysql_onupdate}.
	 * @param ctx the parse tree
	 */
	void enterMysql_onupdate(createParser.Mysql_onupdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#mysql_onupdate}.
	 * @param ctx the parse tree
	 */
	void exitMysql_onupdate(createParser.Mysql_onupdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#mysql_comment}.
	 * @param ctx the parse tree
	 */
	void enterMysql_comment(createParser.Mysql_commentContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#mysql_comment}.
	 * @param ctx the parse tree
	 */
	void exitMysql_comment(createParser.Mysql_commentContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#mysql_function}.
	 * @param ctx the parse tree
	 */
	void enterMysql_function(createParser.Mysql_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#mysql_function}.
	 * @param ctx the parse tree
	 */
	void exitMysql_function(createParser.Mysql_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#advance_data}.
	 * @param ctx the parse tree
	 */
	void enterAdvance_data(createParser.Advance_dataContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#advance_data}.
	 * @param ctx the parse tree
	 */
	void exitAdvance_data(createParser.Advance_dataContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#datatype}.
	 * @param ctx the parse tree
	 */
	void enterDatatype(createParser.DatatypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#datatype}.
	 * @param ctx the parse tree
	 */
	void exitDatatype(createParser.DatatypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#inttype}.
	 * @param ctx the parse tree
	 */
	void enterInttype(createParser.InttypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#inttype}.
	 * @param ctx the parse tree
	 */
	void exitInttype(createParser.InttypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#int_range}.
	 * @param ctx the parse tree
	 */
	void enterInt_range(createParser.Int_rangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#int_range}.
	 * @param ctx the parse tree
	 */
	void exitInt_range(createParser.Int_rangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#unsigned}.
	 * @param ctx the parse tree
	 */
	void enterUnsigned(createParser.UnsignedContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#unsigned}.
	 * @param ctx the parse tree
	 */
	void exitUnsigned(createParser.UnsignedContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#doubletype}.
	 * @param ctx the parse tree
	 */
	void enterDoubletype(createParser.DoubletypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#doubletype}.
	 * @param ctx the parse tree
	 */
	void exitDoubletype(createParser.DoubletypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#double_range}.
	 * @param ctx the parse tree
	 */
	void enterDouble_range(createParser.Double_rangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#double_range}.
	 * @param ctx the parse tree
	 */
	void exitDouble_range(createParser.Double_rangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#stringtype}.
	 * @param ctx the parse tree
	 */
	void enterStringtype(createParser.StringtypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#stringtype}.
	 * @param ctx the parse tree
	 */
	void exitStringtype(createParser.StringtypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#string_range}.
	 * @param ctx the parse tree
	 */
	void enterString_range(createParser.String_rangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#string_range}.
	 * @param ctx the parse tree
	 */
	void exitString_range(createParser.String_rangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#lobtype}.
	 * @param ctx the parse tree
	 */
	void enterLobtype(createParser.LobtypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#lobtype}.
	 * @param ctx the parse tree
	 */
	void exitLobtype(createParser.LobtypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#booltype}.
	 * @param ctx the parse tree
	 */
	void enterBooltype(createParser.BooltypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#booltype}.
	 * @param ctx the parse tree
	 */
	void exitBooltype(createParser.BooltypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#date}.
	 * @param ctx the parse tree
	 */
	void enterDate(createParser.DateContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#date}.
	 * @param ctx the parse tree
	 */
	void exitDate(createParser.DateContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#datetime}.
	 * @param ctx the parse tree
	 */
	void enterDatetime(createParser.DatetimeContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#datetime}.
	 * @param ctx the parse tree
	 */
	void exitDatetime(createParser.DatetimeContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#date_range}.
	 * @param ctx the parse tree
	 */
	void enterDate_range(createParser.Date_rangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#date_range}.
	 * @param ctx the parse tree
	 */
	void exitDate_range(createParser.Date_rangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#data}.
	 * @param ctx the parse tree
	 */
	void enterData(createParser.DataContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#data}.
	 * @param ctx the parse tree
	 */
	void exitData(createParser.DataContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(createParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(createParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#decimal}.
	 * @param ctx the parse tree
	 */
	void enterDecimal(createParser.DecimalContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#decimal}.
	 * @param ctx the parse tree
	 */
	void exitDecimal(createParser.DecimalContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(createParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(createParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(createParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(createParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#regular_string}.
	 * @param ctx the parse tree
	 */
	void enterRegular_string(createParser.Regular_stringContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#regular_string}.
	 * @param ctx the parse tree
	 */
	void exitRegular_string(createParser.Regular_stringContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#character_type}.
	 * @param ctx the parse tree
	 */
	void enterCharacter_type(createParser.Character_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#character_type}.
	 * @param ctx the parse tree
	 */
	void exitCharacter_type(createParser.Character_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#collate_type}.
	 * @param ctx the parse tree
	 */
	void enterCollate_type(createParser.Collate_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#collate_type}.
	 * @param ctx the parse tree
	 */
	void exitCollate_type(createParser.Collate_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#row_formattype}.
	 * @param ctx the parse tree
	 */
	void enterRow_formattype(createParser.Row_formattypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#row_formattype}.
	 * @param ctx the parse tree
	 */
	void exitRow_formattype(createParser.Row_formattypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#binary_comparison_operator}.
	 * @param ctx the parse tree
	 */
	void enterBinary_comparison_operator(createParser.Binary_comparison_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#binary_comparison_operator}.
	 * @param ctx the parse tree
	 */
	void exitBinary_comparison_operator(createParser.Binary_comparison_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link createParser#boolLinkOption}.
	 * @param ctx the parse tree
	 */
	void enterBoolLinkOption(createParser.BoolLinkOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link createParser#boolLinkOption}.
	 * @param ctx the parse tree
	 */
	void exitBoolLinkOption(createParser.BoolLinkOptionContext ctx);
}