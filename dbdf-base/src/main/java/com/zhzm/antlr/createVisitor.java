// Generated from D:/Document/OneDrive/CodeRepo/DatabaseDataCreater/dbdf-base/antlr\create.g4 by ANTLR 4.9.2
package com.zhzm.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link createParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface createVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link createParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(createParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#create}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate(createParser.CreateContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#tablecreatebranch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTablecreatebranch(createParser.TablecreatebranchContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#relationproperties}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationproperties(createParser.RelationpropertiesContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#column}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn(createParser.ColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#column_options}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_options(createParser.Column_optionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#dbdf_options}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDbdf_options(createParser.Dbdf_optionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#hasNull}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHasNull(createParser.HasNullContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#tableproperties}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableproperties(createParser.TablepropertiesContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#full_tablename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFull_tablename(createParser.Full_tablenameContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#tablespacename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTablespacename(createParser.TablespacenameContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#tablename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTablename(createParser.TablenameContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#listname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListname(createParser.ListnameContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#indexname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexname(createParser.IndexnameContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#objectName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectName(createParser.ObjectNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#ranges}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRanges(createParser.RangesContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#isnull}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsnull(createParser.IsnullContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#not_null}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot_null(createParser.Not_nullContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#inline_constrain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInline_constrain(createParser.Inline_constrainContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#inline_uniqueKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInline_uniqueKey(createParser.Inline_uniqueKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#inline_primaryKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInline_primaryKey(createParser.Inline_primaryKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#inline_foreignKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInline_foreignKey(createParser.Inline_foreignKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#inline_generalKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInline_generalKey(createParser.Inline_generalKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#inline_checkKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInline_checkKey(createParser.Inline_checkKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#constrain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstrain(createParser.ConstrainContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#indexType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexType(createParser.IndexTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#general_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneral_key(createParser.General_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#primary_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary_key(createParser.Primary_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#foreign_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForeign_key(createParser.Foreign_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#unique_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnique_key(createParser.Unique_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#check_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheck_key(createParser.Check_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#check_key_options}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheck_key_options(createParser.Check_key_optionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#general_key_options}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneral_key_options(createParser.General_key_optionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#autoincreasing}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAutoincreasing(createParser.AutoincreasingContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#hasDefault}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHasDefault(createParser.HasDefaultContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#charset}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharset(createParser.CharsetContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#collate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollate(createParser.CollateContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#oracle_tableoption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOracle_tableoption(createParser.Oracle_tableoptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#oracle_tablespaceset}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOracle_tablespaceset(createParser.Oracle_tablespacesetContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#mysql_tableoptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMysql_tableoptions(createParser.Mysql_tableoptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#mysql_tableoption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMysql_tableoption(createParser.Mysql_tableoptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#mysql_engine_set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMysql_engine_set(createParser.Mysql_engine_setContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#mysql_character_set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMysql_character_set(createParser.Mysql_character_setContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#mysql_collate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMysql_collate(createParser.Mysql_collateContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#mysql_rowfomat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMysql_rowfomat(createParser.Mysql_rowfomatContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#mysql_incrementset}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMysql_incrementset(createParser.Mysql_incrementsetContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#mysql_onupdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMysql_onupdate(createParser.Mysql_onupdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#mysql_comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMysql_comment(createParser.Mysql_commentContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#mysql_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMysql_function(createParser.Mysql_functionContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#advance_data}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdvance_data(createParser.Advance_dataContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#numberset}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberset(createParser.NumbersetContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#datatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatatype(createParser.DatatypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#inttype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInttype(createParser.InttypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#int_range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt_range(createParser.Int_rangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#unsigned}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnsigned(createParser.UnsignedContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#doubletype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubletype(createParser.DoubletypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#double_range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDouble_range(createParser.Double_rangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#stringtype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringtype(createParser.StringtypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#string_range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_range(createParser.String_rangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#lobtype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobtype(createParser.LobtypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#booltype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooltype(createParser.BooltypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#date}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate(createParser.DateContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#datetime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatetime(createParser.DatetimeContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#date_range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate_range(createParser.Date_rangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#data}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData(createParser.DataContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(createParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#decimal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimal(createParser.DecimalContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(createParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(createParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#regular_string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegular_string(createParser.Regular_stringContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#character_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacter_type(createParser.Character_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#collate_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollate_type(createParser.Collate_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#row_formattype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRow_formattype(createParser.Row_formattypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#binary_comparison_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary_comparison_operator(createParser.Binary_comparison_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link createParser#boolLinkOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLinkOption(createParser.BoolLinkOptionContext ctx);
}