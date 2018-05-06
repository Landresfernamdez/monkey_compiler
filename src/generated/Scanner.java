// Generated from C:/Users/Jurguen/Desktop/Proyectos 2018/Segundo proyecto lenguaje/Primerproyecto programado Jurguen Romero Andres Fernandez/monkey_compiler-master/monkey_compiler-master/Interfaz compiladores\Scanner.g4 by ANTLR 4.7
package generated;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Scanner extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LET=1, RETURN=2, TRUE=3, FALSE=4, LEN=5, FIRST=6, LAST=7, REST=8, PUSH=9, 
		FN=10, PUTS=11, IF=12, ELSE=13, L=14, P=15, LE=16, PE=17, EE=18, SUM=19, 
		SUB=20, MUL=21, DIV=22, EQUAL=23, PCOMA=24, PCI=25, PCD=26, PRI=27, PRD=28, 
		DCOM=29, COMA=30, LI=31, LD=32, DPTS=33, ID=34, INTEGER=35, STRING=36, 
		BOOLEAN=37, WS=38, LINE_COMMENT=39, SPECIAL_COMMENT=40;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LET", "RETURN", "TRUE", "FALSE", "LEN", "FIRST", "LAST", "REST", "PUSH", 
		"FN", "PUTS", "IF", "ELSE", "L", "P", "LE", "PE", "EE", "SUM", "SUB", 
		"MUL", "DIV", "EQUAL", "PCOMA", "PCI", "PCD", "PRI", "PRD", "DCOM", "COMA", 
		"LI", "LD", "DPTS", "ID", "INTEGER", "STRING", "BOOLEAN", "SIGN", "LETTER", 
		"DIGIT", "WS", "LINE_COMMENT", "SPECIAL_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'let'", "'return'", "'true'", "'false'", "'len'", "'first'", "'last'", 
		"'rest'", "'push'", "'fn'", "'puts'", "'if'", "'else'", "'<'", "'>'", 
		"'<='", "'>='", "'=='", "'+'", "'-'", "'*'", "'/'", "'='", "';'", "'['", 
		"']'", "'('", "')'", "'\"'", "','", "'{'", "'}'", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LET", "RETURN", "TRUE", "FALSE", "LEN", "FIRST", "LAST", "REST", 
		"PUSH", "FN", "PUTS", "IF", "ELSE", "L", "P", "LE", "PE", "EE", "SUM", 
		"SUB", "MUL", "DIV", "EQUAL", "PCOMA", "PCI", "PCD", "PRI", "PRD", "DCOM", 
		"COMA", "LI", "LD", "DPTS", "ID", "INTEGER", "STRING", "BOOLEAN", "WS", 
		"LINE_COMMENT", "SPECIAL_COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public Scanner(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Scanner.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2*\u011d\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\20"+
		"\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34"+
		"\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3#\7#\u00c7\n"+
		"#\f#\16#\u00ca\13#\3$\3$\7$\u00ce\n$\f$\16$\u00d1\13$\3%\3%\3%\3%\7%\u00d7"+
		"\n%\f%\16%\u00da\13%\3%\3%\3&\3&\5&\u00e0\n&\3\'\3\'\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u00f2\n\'\3(\3(\3)\3)\3*\6"+
		"*\u00f9\n*\r*\16*\u00fa\3*\3*\3+\3+\3+\3+\7+\u0103\n+\f+\16+\u0106\13"+
		"+\3+\5+\u0109\n+\3+\3+\3+\3+\3,\3,\3,\3,\3,\7,\u0114\n,\f,\16,\u0117\13"+
		",\3,\3,\3,\3,\3,\4\u0104\u0115\2-\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M\2O\2Q\2S(U)W*\3\2"+
		"\4\5\2C\\aac|\5\2\13\f\17\17\"\"\2\u0133\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2S\3"+
		"\2\2\2\2U\3\2\2\2\2W\3\2\2\2\3Y\3\2\2\2\5]\3\2\2\2\7d\3\2\2\2\ti\3\2\2"+
		"\2\13o\3\2\2\2\rs\3\2\2\2\17y\3\2\2\2\21~\3\2\2\2\23\u0083\3\2\2\2\25"+
		"\u0088\3\2\2\2\27\u008b\3\2\2\2\31\u0090\3\2\2\2\33\u0093\3\2\2\2\35\u0098"+
		"\3\2\2\2\37\u009a\3\2\2\2!\u009c\3\2\2\2#\u009f\3\2\2\2%\u00a2\3\2\2\2"+
		"\'\u00a5\3\2\2\2)\u00a7\3\2\2\2+\u00a9\3\2\2\2-\u00ab\3\2\2\2/\u00ad\3"+
		"\2\2\2\61\u00af\3\2\2\2\63\u00b1\3\2\2\2\65\u00b3\3\2\2\2\67\u00b5\3\2"+
		"\2\29\u00b7\3\2\2\2;\u00b9\3\2\2\2=\u00bb\3\2\2\2?\u00bd\3\2\2\2A\u00bf"+
		"\3\2\2\2C\u00c1\3\2\2\2E\u00c3\3\2\2\2G\u00cb\3\2\2\2I\u00d2\3\2\2\2K"+
		"\u00df\3\2\2\2M\u00f1\3\2\2\2O\u00f3\3\2\2\2Q\u00f5\3\2\2\2S\u00f8\3\2"+
		"\2\2U\u00fe\3\2\2\2W\u010e\3\2\2\2YZ\7n\2\2Z[\7g\2\2[\\\7v\2\2\\\4\3\2"+
		"\2\2]^\7t\2\2^_\7g\2\2_`\7v\2\2`a\7w\2\2ab\7t\2\2bc\7p\2\2c\6\3\2\2\2"+
		"de\7v\2\2ef\7t\2\2fg\7w\2\2gh\7g\2\2h\b\3\2\2\2ij\7h\2\2jk\7c\2\2kl\7"+
		"n\2\2lm\7u\2\2mn\7g\2\2n\n\3\2\2\2op\7n\2\2pq\7g\2\2qr\7p\2\2r\f\3\2\2"+
		"\2st\7h\2\2tu\7k\2\2uv\7t\2\2vw\7u\2\2wx\7v\2\2x\16\3\2\2\2yz\7n\2\2z"+
		"{\7c\2\2{|\7u\2\2|}\7v\2\2}\20\3\2\2\2~\177\7t\2\2\177\u0080\7g\2\2\u0080"+
		"\u0081\7u\2\2\u0081\u0082\7v\2\2\u0082\22\3\2\2\2\u0083\u0084\7r\2\2\u0084"+
		"\u0085\7w\2\2\u0085\u0086\7u\2\2\u0086\u0087\7j\2\2\u0087\24\3\2\2\2\u0088"+
		"\u0089\7h\2\2\u0089\u008a\7p\2\2\u008a\26\3\2\2\2\u008b\u008c\7r\2\2\u008c"+
		"\u008d\7w\2\2\u008d\u008e\7v\2\2\u008e\u008f\7u\2\2\u008f\30\3\2\2\2\u0090"+
		"\u0091\7k\2\2\u0091\u0092\7h\2\2\u0092\32\3\2\2\2\u0093\u0094\7g\2\2\u0094"+
		"\u0095\7n\2\2\u0095\u0096\7u\2\2\u0096\u0097\7g\2\2\u0097\34\3\2\2\2\u0098"+
		"\u0099\7>\2\2\u0099\36\3\2\2\2\u009a\u009b\7@\2\2\u009b \3\2\2\2\u009c"+
		"\u009d\7>\2\2\u009d\u009e\7?\2\2\u009e\"\3\2\2\2\u009f\u00a0\7@\2\2\u00a0"+
		"\u00a1\7?\2\2\u00a1$\3\2\2\2\u00a2\u00a3\7?\2\2\u00a3\u00a4\7?\2\2\u00a4"+
		"&\3\2\2\2\u00a5\u00a6\7-\2\2\u00a6(\3\2\2\2\u00a7\u00a8\7/\2\2\u00a8*"+
		"\3\2\2\2\u00a9\u00aa\7,\2\2\u00aa,\3\2\2\2\u00ab\u00ac\7\61\2\2\u00ac"+
		".\3\2\2\2\u00ad\u00ae\7?\2\2\u00ae\60\3\2\2\2\u00af\u00b0\7=\2\2\u00b0"+
		"\62\3\2\2\2\u00b1\u00b2\7]\2\2\u00b2\64\3\2\2\2\u00b3\u00b4\7_\2\2\u00b4"+
		"\66\3\2\2\2\u00b5\u00b6\7*\2\2\u00b68\3\2\2\2\u00b7\u00b8\7+\2\2\u00b8"+
		":\3\2\2\2\u00b9\u00ba\7$\2\2\u00ba<\3\2\2\2\u00bb\u00bc\7.\2\2\u00bc>"+
		"\3\2\2\2\u00bd\u00be\7}\2\2\u00be@\3\2\2\2\u00bf\u00c0\7\177\2\2\u00c0"+
		"B\3\2\2\2\u00c1\u00c2\7<\2\2\u00c2D\3\2\2\2\u00c3\u00c8\5O(\2\u00c4\u00c7"+
		"\5O(\2\u00c5\u00c7\5Q)\2\u00c6\u00c4\3\2\2\2\u00c6\u00c5\3\2\2\2\u00c7"+
		"\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9F\3\2\2\2"+
		"\u00ca\u00c8\3\2\2\2\u00cb\u00cf\5Q)\2\u00cc\u00ce\5Q)\2\u00cd\u00cc\3"+
		"\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0"+
		"H\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d3\5;\36\2\u00d3\u00d8\5O(\2\u00d4"+
		"\u00d7\5O(\2\u00d5\u00d7\5M\'\2\u00d6\u00d4\3\2\2\2\u00d6\u00d5\3\2\2"+
		"\2\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00db"+
		"\3\2\2\2\u00da\u00d8\3\2\2\2\u00db\u00dc\5;\36\2\u00dcJ\3\2\2\2\u00dd"+
		"\u00e0\5\7\4\2\u00de\u00e0\5\t\5\2\u00df\u00dd\3\2\2\2\u00df\u00de\3\2"+
		"\2\2\u00e0L\3\2\2\2\u00e1\u00f2\5/\30\2\u00e2\u00f2\5\61\31\2\u00e3\u00f2"+
		"\5\35\17\2\u00e4\u00f2\5\37\20\2\u00e5\u00f2\5\63\32\2\u00e6\u00f2\5\65"+
		"\33\2\u00e7\u00f2\5\67\34\2\u00e8\u00f2\59\35\2\u00e9\u00f2\5=\37\2\u00ea"+
		"\u00f2\5? \2\u00eb\u00f2\5A!\2\u00ec\u00f2\5C\"\2\u00ed\u00f2\5!\21\2"+
		"\u00ee\u00f2\5#\22\2\u00ef\u00f2\5%\23\2\u00f0\u00f2\5Q)\2\u00f1\u00e1"+
		"\3\2\2\2\u00f1\u00e2\3\2\2\2\u00f1\u00e3\3\2\2\2\u00f1\u00e4\3\2\2\2\u00f1"+
		"\u00e5\3\2\2\2\u00f1\u00e6\3\2\2\2\u00f1\u00e7\3\2\2\2\u00f1\u00e8\3\2"+
		"\2\2\u00f1\u00e9\3\2\2\2\u00f1\u00ea\3\2\2\2\u00f1\u00eb\3\2\2\2\u00f1"+
		"\u00ec\3\2\2\2\u00f1\u00ed\3\2\2\2\u00f1\u00ee\3\2\2\2\u00f1\u00ef\3\2"+
		"\2\2\u00f1\u00f0\3\2\2\2\u00f2N\3\2\2\2\u00f3\u00f4\t\2\2\2\u00f4P\3\2"+
		"\2\2\u00f5\u00f6\4\62;\2\u00f6R\3\2\2\2\u00f7\u00f9\t\3\2\2\u00f8\u00f7"+
		"\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb"+
		"\u00fc\3\2\2\2\u00fc\u00fd\b*\2\2\u00fdT\3\2\2\2\u00fe\u00ff\7\61\2\2"+
		"\u00ff\u0100\7\61\2\2\u0100\u0104\3\2\2\2\u0101\u0103\13\2\2\2\u0102\u0101"+
		"\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0105\3\2\2\2\u0104\u0102\3\2\2\2\u0105"+
		"\u0108\3\2\2\2\u0106\u0104\3\2\2\2\u0107\u0109\7\17\2\2\u0108\u0107\3"+
		"\2\2\2\u0108\u0109\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010b\7\f\2\2\u010b"+
		"\u010c\3\2\2\2\u010c\u010d\b+\2\2\u010dV\3\2\2\2\u010e\u010f\7\61\2\2"+
		"\u010f\u0110\7,\2\2\u0110\u0115\3\2\2\2\u0111\u0114\5W,\2\u0112\u0114"+
		"\13\2\2\2\u0113\u0111\3\2\2\2\u0113\u0112\3\2\2\2\u0114\u0117\3\2\2\2"+
		"\u0115\u0116\3\2\2\2\u0115\u0113\3\2\2\2\u0116\u0118\3\2\2\2\u0117\u0115"+
		"\3\2\2\2\u0118\u0119\7,\2\2\u0119\u011a\7\61\2\2\u011a\u011b\3\2\2\2\u011b"+
		"\u011c\b,\2\2\u011cX\3\2\2\2\17\2\u00c6\u00c8\u00cf\u00d6\u00d8\u00df"+
		"\u00f1\u00fa\u0104\u0108\u0113\u0115\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}