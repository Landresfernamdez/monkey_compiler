// Generated from C:/Users/Andres/Documents/ProyectsGit/monkey_compiler/Interfaz compiladores\Scanner.g4 by ANTLR 4.7
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
		LET=1, RETURN=2, ID=3, EQUAL=4, PCOMA=5, L=6, P=7, LE=8, PE=9, EE=10, 
		SUM=11, SUB=12, MUL=13, DIV=14, PCI=15, PCD=16, PRI=17, PRD=18, DCOM=19, 
		INTEGER=20, STRING=21, TRUE=22, FALSE=23, LEN=24, FIRST=25, LAST=26, REST=27, 
		PUSH=28, FN=29, COMA=30, LI=31, LD=32, DPTS=33, PUTS=34, IF=35, ELSE=36, 
		SPACE=37, NUM=38, OPERA=39, BOOLEAN=40, WS=41, LINE_COMMENT=42, SPECIAL_COMMENT=43;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LET", "RETURN", "ID", "EQUAL", "PCOMA", "L", "P", "LE", "PE", "EE", "SUM", 
		"SUB", "MUL", "DIV", "PCI", "PCD", "PRI", "PRD", "DCOM", "INTEGER", "STRING", 
		"TRUE", "FALSE", "LEN", "FIRST", "LAST", "REST", "PUSH", "FN", "COMA", 
		"LI", "LD", "DPTS", "PUTS", "IF", "ELSE", "SPACE", "NUM", "OPERA", "BOOLEAN", 
		"SIGN", "LETTER", "DIGIT", "OPERATOR", "WS", "LINE_COMMENT", "SPECIAL_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'let'", "'return'", null, "'='", "';'", "'<'", "'>'", "'<='", "'>='", 
		"'=='", "'+'", "'-'", "'*'", "'/'", "'['", "']'", "'('", "')'", "'\"'", 
		null, null, "'true'", "'false'", "'len'", "'first'", "'last'", "'rest'", 
		"'push'", null, "','", "'{'", "'}'", "':'", "'puts'", "'if'", "'else'", 
		"' '"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LET", "RETURN", "ID", "EQUAL", "PCOMA", "L", "P", "LE", "PE", "EE", 
		"SUM", "SUB", "MUL", "DIV", "PCI", "PCD", "PRI", "PRD", "DCOM", "INTEGER", 
		"STRING", "TRUE", "FALSE", "LEN", "FIRST", "LAST", "REST", "PUSH", "FN", 
		"COMA", "LI", "LD", "DPTS", "PUTS", "IF", "ELSE", "SPACE", "NUM", "OPERA", 
		"BOOLEAN", "WS", "LINE_COMMENT", "SPECIAL_COMMENT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2-\u0137\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\4\3\4\3\4\7\4p\n\4\f\4\16\4s\13\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b"+
		"\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16"+
		"\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\25\7\25\u009b\n\25\f\25\16\25\u009e\13\25\3\26\3\26\3\26\3\26\7\26"+
		"\u00a4\n\26\f\26\16\26\u00a7\13\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\""+
		"\3#\3#\3#\3#\3#\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&\3\'\3\'\7\'\u00ed\n\'\f"+
		"\'\16\'\u00f0\13\'\3(\3(\3)\3)\5)\u00f6\n)\3*\3*\3*\3*\3*\3*\3*\3*\3*"+
		"\3*\3*\3*\3*\3*\3*\3*\3*\3*\5*\u010a\n*\3+\3+\3,\3,\3-\3-\3.\6.\u0113"+
		"\n.\r.\16.\u0114\3.\3.\3/\3/\3/\3/\7/\u011d\n/\f/\16/\u0120\13/\3/\5/"+
		"\u0123\n/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\7\60\u012e\n\60\f\60\16"+
		"\60\u0131\13\60\3\60\3\60\3\60\3\60\3\60\4\u011e\u012f\2\61\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C"+
		"#E$G%I&K\'M(O)Q*S\2U\2W\2Y\2[+],_-\3\2\5\5\2C\\aac|\5\2,-//\61\61\5\2"+
		"\13\f\17\17\"\"\2\u0150\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2"+
		"Q\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\3a\3\2\2\2\5e\3\2\2\2\7l\3"+
		"\2\2\2\tt\3\2\2\2\13v\3\2\2\2\rx\3\2\2\2\17z\3\2\2\2\21|\3\2\2\2\23\177"+
		"\3\2\2\2\25\u0082\3\2\2\2\27\u0085\3\2\2\2\31\u0087\3\2\2\2\33\u0089\3"+
		"\2\2\2\35\u008b\3\2\2\2\37\u008d\3\2\2\2!\u008f\3\2\2\2#\u0091\3\2\2\2"+
		"%\u0093\3\2\2\2\'\u0095\3\2\2\2)\u0097\3\2\2\2+\u009f\3\2\2\2-\u00aa\3"+
		"\2\2\2/\u00af\3\2\2\2\61\u00b5\3\2\2\2\63\u00b9\3\2\2\2\65\u00bf\3\2\2"+
		"\2\67\u00c4\3\2\2\29\u00c9\3\2\2\2;\u00ce\3\2\2\2=\u00d3\3\2\2\2?\u00d5"+
		"\3\2\2\2A\u00d7\3\2\2\2C\u00d9\3\2\2\2E\u00db\3\2\2\2G\u00e0\3\2\2\2I"+
		"\u00e3\3\2\2\2K\u00e8\3\2\2\2M\u00ea\3\2\2\2O\u00f1\3\2\2\2Q\u00f5\3\2"+
		"\2\2S\u0109\3\2\2\2U\u010b\3\2\2\2W\u010d\3\2\2\2Y\u010f\3\2\2\2[\u0112"+
		"\3\2\2\2]\u0118\3\2\2\2_\u0128\3\2\2\2ab\7n\2\2bc\7g\2\2cd\7v\2\2d\4\3"+
		"\2\2\2ef\7t\2\2fg\7g\2\2gh\7v\2\2hi\7w\2\2ij\7t\2\2jk\7p\2\2k\6\3\2\2"+
		"\2lq\5U+\2mp\5U+\2np\5W,\2om\3\2\2\2on\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3"+
		"\2\2\2r\b\3\2\2\2sq\3\2\2\2tu\7?\2\2u\n\3\2\2\2vw\7=\2\2w\f\3\2\2\2xy"+
		"\7>\2\2y\16\3\2\2\2z{\7@\2\2{\20\3\2\2\2|}\7>\2\2}~\7?\2\2~\22\3\2\2\2"+
		"\177\u0080\7@\2\2\u0080\u0081\7?\2\2\u0081\24\3\2\2\2\u0082\u0083\7?\2"+
		"\2\u0083\u0084\7?\2\2\u0084\26\3\2\2\2\u0085\u0086\7-\2\2\u0086\30\3\2"+
		"\2\2\u0087\u0088\7/\2\2\u0088\32\3\2\2\2\u0089\u008a\7,\2\2\u008a\34\3"+
		"\2\2\2\u008b\u008c\7\61\2\2\u008c\36\3\2\2\2\u008d\u008e\7]\2\2\u008e"+
		" \3\2\2\2\u008f\u0090\7_\2\2\u0090\"\3\2\2\2\u0091\u0092\7*\2\2\u0092"+
		"$\3\2\2\2\u0093\u0094\7+\2\2\u0094&\3\2\2\2\u0095\u0096\7$\2\2\u0096("+
		"\3\2\2\2\u0097\u009c\5W,\2\u0098\u009b\5W,\2\u0099\u009b\5W,\2\u009a\u0098"+
		"\3\2\2\2\u009a\u0099\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d*\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a0\5\'\24\2"+
		"\u00a0\u00a5\5U+\2\u00a1\u00a4\5U+\2\u00a2\u00a4\5S*\2\u00a3\u00a1\3\2"+
		"\2\2\u00a3\u00a2\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5"+
		"\u00a6\3\2\2\2\u00a6\u00a8\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00a9\5\'"+
		"\24\2\u00a9,\3\2\2\2\u00aa\u00ab\7v\2\2\u00ab\u00ac\7t\2\2\u00ac\u00ad"+
		"\7w\2\2\u00ad\u00ae\7g\2\2\u00ae.\3\2\2\2\u00af\u00b0\7h\2\2\u00b0\u00b1"+
		"\7c\2\2\u00b1\u00b2\7n\2\2\u00b2\u00b3\7u\2\2\u00b3\u00b4\7g\2\2\u00b4"+
		"\60\3\2\2\2\u00b5\u00b6\7n\2\2\u00b6\u00b7\7g\2\2\u00b7\u00b8\7p\2\2\u00b8"+
		"\62\3\2\2\2\u00b9\u00ba\7h\2\2\u00ba\u00bb\7k\2\2\u00bb\u00bc\7t\2\2\u00bc"+
		"\u00bd\7u\2\2\u00bd\u00be\7v\2\2\u00be\64\3\2\2\2\u00bf\u00c0\7n\2\2\u00c0"+
		"\u00c1\7c\2\2\u00c1\u00c2\7u\2\2\u00c2\u00c3\7v\2\2\u00c3\66\3\2\2\2\u00c4"+
		"\u00c5\7t\2\2\u00c5\u00c6\7g\2\2\u00c6\u00c7\7u\2\2\u00c7\u00c8\7v\2\2"+
		"\u00c88\3\2\2\2\u00c9\u00ca\7r\2\2\u00ca\u00cb\7w\2\2\u00cb\u00cc\7u\2"+
		"\2\u00cc\u00cd\7j\2\2\u00cd:\3\2\2\2\u00ce\u00cf\7h\2\2\u00cf\u00d0\7"+
		"p\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\5\7\4\2\u00d2<\3\2\2\2\u00d3\u00d4"+
		"\7.\2\2\u00d4>\3\2\2\2\u00d5\u00d6\7}\2\2\u00d6@\3\2\2\2\u00d7\u00d8\7"+
		"\177\2\2\u00d8B\3\2\2\2\u00d9\u00da\7<\2\2\u00daD\3\2\2\2\u00db\u00dc"+
		"\7r\2\2\u00dc\u00dd\7w\2\2\u00dd\u00de\7v\2\2\u00de\u00df\7u\2\2\u00df"+
		"F\3\2\2\2\u00e0\u00e1\7k\2\2\u00e1\u00e2\7h\2\2\u00e2H\3\2\2\2\u00e3\u00e4"+
		"\7g\2\2\u00e4\u00e5\7n\2\2\u00e5\u00e6\7u\2\2\u00e6\u00e7\7g\2\2\u00e7"+
		"J\3\2\2\2\u00e8\u00e9\7\"\2\2\u00e9L\3\2\2\2\u00ea\u00ee\5W,\2\u00eb\u00ed"+
		"\5W,\2\u00ec\u00eb\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee"+
		"\u00ef\3\2\2\2\u00efN\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f2\5Y-\2\u00f2"+
		"P\3\2\2\2\u00f3\u00f6\5-\27\2\u00f4\u00f6\5/\30\2\u00f5\u00f3\3\2\2\2"+
		"\u00f5\u00f4\3\2\2\2\u00f6R\3\2\2\2\u00f7\u010a\5\t\5\2\u00f8\u010a\5"+
		"\13\6\2\u00f9\u010a\5\r\7\2\u00fa\u010a\5\17\b\2\u00fb\u010a\5O(\2\u00fc"+
		"\u010a\5\37\20\2\u00fd\u010a\5!\21\2\u00fe\u010a\5#\22\2\u00ff\u010a\5"+
		"%\23\2\u0100\u010a\5=\37\2\u0101\u010a\5? \2\u0102\u010a\5A!\2\u0103\u010a"+
		"\5C\"\2\u0104\u010a\5\21\t\2\u0105\u010a\5\23\n\2\u0106\u010a\5\25\13"+
		"\2\u0107\u010a\5K&\2\u0108\u010a\5M\'\2\u0109\u00f7\3\2\2\2\u0109\u00f8"+
		"\3\2\2\2\u0109\u00f9\3\2\2\2\u0109\u00fa\3\2\2\2\u0109\u00fb\3\2\2\2\u0109"+
		"\u00fc\3\2\2\2\u0109\u00fd\3\2\2\2\u0109\u00fe\3\2\2\2\u0109\u00ff\3\2"+
		"\2\2\u0109\u0100\3\2\2\2\u0109\u0101\3\2\2\2\u0109\u0102\3\2\2\2\u0109"+
		"\u0103\3\2\2\2\u0109\u0104\3\2\2\2\u0109\u0105\3\2\2\2\u0109\u0106\3\2"+
		"\2\2\u0109\u0107\3\2\2\2\u0109\u0108\3\2\2\2\u010aT\3\2\2\2\u010b\u010c"+
		"\t\2\2\2\u010cV\3\2\2\2\u010d\u010e\4\62;\2\u010eX\3\2\2\2\u010f\u0110"+
		"\t\3\2\2\u0110Z\3\2\2\2\u0111\u0113\t\4\2\2\u0112\u0111\3\2\2\2\u0113"+
		"\u0114\3\2\2\2\u0114\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0116\3\2"+
		"\2\2\u0116\u0117\b.\2\2\u0117\\\3\2\2\2\u0118\u0119\7\61\2\2\u0119\u011a"+
		"\7\61\2\2\u011a\u011e\3\2\2\2\u011b\u011d\13\2\2\2\u011c\u011b\3\2\2\2"+
		"\u011d\u0120\3\2\2\2\u011e\u011f\3\2\2\2\u011e\u011c\3\2\2\2\u011f\u0122"+
		"\3\2\2\2\u0120\u011e\3\2\2\2\u0121\u0123\7\17\2\2\u0122\u0121\3\2\2\2"+
		"\u0122\u0123\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0125\7\f\2\2\u0125\u0126"+
		"\3\2\2\2\u0126\u0127\b/\2\2\u0127^\3\2\2\2\u0128\u0129\7\61\2\2\u0129"+
		"\u012a\7,\2\2\u012a\u012f\3\2\2\2\u012b\u012e\5_\60\2\u012c\u012e\13\2"+
		"\2\2\u012d\u012b\3\2\2\2\u012d\u012c\3\2\2\2\u012e\u0131\3\2\2\2\u012f"+
		"\u0130\3\2\2\2\u012f\u012d\3\2\2\2\u0130\u0132\3\2\2\2\u0131\u012f\3\2"+
		"\2\2\u0132\u0133\7,\2\2\u0133\u0134\7\61\2\2\u0134\u0135\3\2\2\2\u0135"+
		"\u0136\b\60\2\2\u0136`\3\2\2\2\21\2oq\u009a\u009c\u00a3\u00a5\u00ee\u00f5"+
		"\u0109\u0114\u011e\u0122\u012d\u012f\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}