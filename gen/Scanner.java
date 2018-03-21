// Generated from C:/Users/Andres/Documents/ProyectsGit/monkey_compiler/Interfaz compiladores\Scanner.g4 by ANTLR 4.7
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
		NUM=37, OPERA=38, BOOLEAN=39, WS=40, LINE_COMMENT=41, SPECIAL_COMMENT=42;
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
		"LI", "LD", "DPTS", "PUTS", "IF", "ELSE", "NUM", "OPERA", "BOOLEAN", "SIGN", 
		"LETTER", "DIGIT", "OPERATOR", "WS", "LINE_COMMENT", "SPECIAL_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'let'", "'return'", null, "'='", "';'", "'<'", "'>'", "'<='", "'>='", 
		"'=='", "'+'", "'-'", "'*'", "'/'", "'['", "']'", "'('", "')'", "'\"'", 
		null, null, "'true'", "'false'", "'len'", "'first'", "'last'", "'rest'", 
		"'push'", null, "','", "'{'", "'}'", "':'", "'puts'", "'if'", "'else'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LET", "RETURN", "ID", "EQUAL", "PCOMA", "L", "P", "LE", "PE", "EE", 
		"SUM", "SUB", "MUL", "DIV", "PCI", "PCD", "PRI", "PRD", "DCOM", "INTEGER", 
		"STRING", "TRUE", "FALSE", "LEN", "FIRST", "LAST", "REST", "PUSH", "FN", 
		"COMA", "LI", "LD", "DPTS", "PUTS", "IF", "ELSE", "NUM", "OPERA", "BOOLEAN", 
		"WS", "LINE_COMMENT", "SPECIAL_COMMENT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2,\u0132\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\7\4n\n\4\f\4\16\4q\13\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17"+
		"\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\7\25"+
		"\u0099\n\25\f\25\16\25\u009c\13\25\3\26\3\26\3\26\3\26\7\26\u00a2\n\26"+
		"\f\26\16\26\u00a5\13\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3"+
		"\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3#\3"+
		"#\3#\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&\7&\u00e9\n&\f&\16&\u00ec\13&\3\'\3"+
		"\'\3(\3(\5(\u00f2\n(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3"+
		")\5)\u0105\n)\3*\3*\3+\3+\3,\3,\3-\6-\u010e\n-\r-\16-\u010f\3-\3-\3.\3"+
		".\3.\3.\7.\u0118\n.\f.\16.\u011b\13.\3.\5.\u011e\n.\3.\3.\3.\3.\3/\3/"+
		"\3/\3/\3/\7/\u0129\n/\f/\16/\u012c\13/\3/\3/\3/\3/\3/\4\u0119\u012a\2"+
		"\60\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q\2S\2U\2W\2Y*[+],\3\2\5\5\2C\\aac|\5\2,-//"+
		"\61\61\5\2\13\f\17\17\"\"\2\u014a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2"+
		"\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2"+
		"\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2"+
		"O\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\3_\3\2\2\2\5c\3\2\2\2\7j\3"+
		"\2\2\2\tr\3\2\2\2\13t\3\2\2\2\rv\3\2\2\2\17x\3\2\2\2\21z\3\2\2\2\23}\3"+
		"\2\2\2\25\u0080\3\2\2\2\27\u0083\3\2\2\2\31\u0085\3\2\2\2\33\u0087\3\2"+
		"\2\2\35\u0089\3\2\2\2\37\u008b\3\2\2\2!\u008d\3\2\2\2#\u008f\3\2\2\2%"+
		"\u0091\3\2\2\2\'\u0093\3\2\2\2)\u0095\3\2\2\2+\u009d\3\2\2\2-\u00a8\3"+
		"\2\2\2/\u00ad\3\2\2\2\61\u00b3\3\2\2\2\63\u00b7\3\2\2\2\65\u00bd\3\2\2"+
		"\2\67\u00c2\3\2\2\29\u00c7\3\2\2\2;\u00cc\3\2\2\2=\u00d1\3\2\2\2?\u00d3"+
		"\3\2\2\2A\u00d5\3\2\2\2C\u00d7\3\2\2\2E\u00d9\3\2\2\2G\u00de\3\2\2\2I"+
		"\u00e1\3\2\2\2K\u00e6\3\2\2\2M\u00ed\3\2\2\2O\u00f1\3\2\2\2Q\u0104\3\2"+
		"\2\2S\u0106\3\2\2\2U\u0108\3\2\2\2W\u010a\3\2\2\2Y\u010d\3\2\2\2[\u0113"+
		"\3\2\2\2]\u0123\3\2\2\2_`\7n\2\2`a\7g\2\2ab\7v\2\2b\4\3\2\2\2cd\7t\2\2"+
		"de\7g\2\2ef\7v\2\2fg\7w\2\2gh\7t\2\2hi\7p\2\2i\6\3\2\2\2jo\5S*\2kn\5S"+
		"*\2ln\5U+\2mk\3\2\2\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2p\b\3\2\2"+
		"\2qo\3\2\2\2rs\7?\2\2s\n\3\2\2\2tu\7=\2\2u\f\3\2\2\2vw\7>\2\2w\16\3\2"+
		"\2\2xy\7@\2\2y\20\3\2\2\2z{\7>\2\2{|\7?\2\2|\22\3\2\2\2}~\7@\2\2~\177"+
		"\7?\2\2\177\24\3\2\2\2\u0080\u0081\7?\2\2\u0081\u0082\7?\2\2\u0082\26"+
		"\3\2\2\2\u0083\u0084\7-\2\2\u0084\30\3\2\2\2\u0085\u0086\7/\2\2\u0086"+
		"\32\3\2\2\2\u0087\u0088\7,\2\2\u0088\34\3\2\2\2\u0089\u008a\7\61\2\2\u008a"+
		"\36\3\2\2\2\u008b\u008c\7]\2\2\u008c \3\2\2\2\u008d\u008e\7_\2\2\u008e"+
		"\"\3\2\2\2\u008f\u0090\7*\2\2\u0090$\3\2\2\2\u0091\u0092\7+\2\2\u0092"+
		"&\3\2\2\2\u0093\u0094\7$\2\2\u0094(\3\2\2\2\u0095\u009a\5U+\2\u0096\u0099"+
		"\5U+\2\u0097\u0099\5U+\2\u0098\u0096\3\2\2\2\u0098\u0097\3\2\2\2\u0099"+
		"\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b*\3\2\2\2"+
		"\u009c\u009a\3\2\2\2\u009d\u009e\5\'\24\2\u009e\u00a3\5S*\2\u009f\u00a2"+
		"\5S*\2\u00a0\u00a2\5Q)\2\u00a1\u009f\3\2\2\2\u00a1\u00a0\3\2\2\2\u00a2"+
		"\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a6\3\2"+
		"\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00a7\5\'\24\2\u00a7,\3\2\2\2\u00a8\u00a9"+
		"\7v\2\2\u00a9\u00aa\7t\2\2\u00aa\u00ab\7w\2\2\u00ab\u00ac\7g\2\2\u00ac"+
		".\3\2\2\2\u00ad\u00ae\7h\2\2\u00ae\u00af\7c\2\2\u00af\u00b0\7n\2\2\u00b0"+
		"\u00b1\7u\2\2\u00b1\u00b2\7g\2\2\u00b2\60\3\2\2\2\u00b3\u00b4\7n\2\2\u00b4"+
		"\u00b5\7g\2\2\u00b5\u00b6\7p\2\2\u00b6\62\3\2\2\2\u00b7\u00b8\7h\2\2\u00b8"+
		"\u00b9\7k\2\2\u00b9\u00ba\7t\2\2\u00ba\u00bb\7u\2\2\u00bb\u00bc\7v\2\2"+
		"\u00bc\64\3\2\2\2\u00bd\u00be\7n\2\2\u00be\u00bf\7c\2\2\u00bf\u00c0\7"+
		"u\2\2\u00c0\u00c1\7v\2\2\u00c1\66\3\2\2\2\u00c2\u00c3\7t\2\2\u00c3\u00c4"+
		"\7g\2\2\u00c4\u00c5\7u\2\2\u00c5\u00c6\7v\2\2\u00c68\3\2\2\2\u00c7\u00c8"+
		"\7r\2\2\u00c8\u00c9\7w\2\2\u00c9\u00ca\7u\2\2\u00ca\u00cb\7j\2\2\u00cb"+
		":\3\2\2\2\u00cc\u00cd\7h\2\2\u00cd\u00ce\7p\2\2\u00ce\u00cf\3\2\2\2\u00cf"+
		"\u00d0\5\7\4\2\u00d0<\3\2\2\2\u00d1\u00d2\7.\2\2\u00d2>\3\2\2\2\u00d3"+
		"\u00d4\7}\2\2\u00d4@\3\2\2\2\u00d5\u00d6\7\177\2\2\u00d6B\3\2\2\2\u00d7"+
		"\u00d8\7<\2\2\u00d8D\3\2\2\2\u00d9\u00da\7r\2\2\u00da\u00db\7w\2\2\u00db"+
		"\u00dc\7v\2\2\u00dc\u00dd\7u\2\2\u00ddF\3\2\2\2\u00de\u00df\7k\2\2\u00df"+
		"\u00e0\7h\2\2\u00e0H\3\2\2\2\u00e1\u00e2\7g\2\2\u00e2\u00e3\7n\2\2\u00e3"+
		"\u00e4\7u\2\2\u00e4\u00e5\7g\2\2\u00e5J\3\2\2\2\u00e6\u00ea\5U+\2\u00e7"+
		"\u00e9\5U+\2\u00e8\u00e7\3\2\2\2\u00e9\u00ec\3\2\2\2\u00ea\u00e8\3\2\2"+
		"\2\u00ea\u00eb\3\2\2\2\u00ebL\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ed\u00ee"+
		"\5W,\2\u00eeN\3\2\2\2\u00ef\u00f2\5-\27\2\u00f0\u00f2\5/\30\2\u00f1\u00ef"+
		"\3\2\2\2\u00f1\u00f0\3\2\2\2\u00f2P\3\2\2\2\u00f3\u0105\5\t\5\2\u00f4"+
		"\u0105\5\13\6\2\u00f5\u0105\5\r\7\2\u00f6\u0105\5\17\b\2\u00f7\u0105\5"+
		"M\'\2\u00f8\u0105\5\37\20\2\u00f9\u0105\5!\21\2\u00fa\u0105\5#\22\2\u00fb"+
		"\u0105\5%\23\2\u00fc\u0105\5=\37\2\u00fd\u0105\5? \2\u00fe\u0105\5A!\2"+
		"\u00ff\u0105\5C\"\2\u0100\u0105\5\21\t\2\u0101\u0105\5\23\n\2\u0102\u0105"+
		"\5\25\13\2\u0103\u0105\5K&\2\u0104\u00f3\3\2\2\2\u0104\u00f4\3\2\2\2\u0104"+
		"\u00f5\3\2\2\2\u0104\u00f6\3\2\2\2\u0104\u00f7\3\2\2\2\u0104\u00f8\3\2"+
		"\2\2\u0104\u00f9\3\2\2\2\u0104\u00fa\3\2\2\2\u0104\u00fb\3\2\2\2\u0104"+
		"\u00fc\3\2\2\2\u0104\u00fd\3\2\2\2\u0104\u00fe\3\2\2\2\u0104\u00ff\3\2"+
		"\2\2\u0104\u0100\3\2\2\2\u0104\u0101\3\2\2\2\u0104\u0102\3\2\2\2\u0104"+
		"\u0103\3\2\2\2\u0105R\3\2\2\2\u0106\u0107\t\2\2\2\u0107T\3\2\2\2\u0108"+
		"\u0109\4\62;\2\u0109V\3\2\2\2\u010a\u010b\t\3\2\2\u010bX\3\2\2\2\u010c"+
		"\u010e\t\4\2\2\u010d\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u010d\3\2"+
		"\2\2\u010f\u0110\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0112\b-\2\2\u0112"+
		"Z\3\2\2\2\u0113\u0114\7\61\2\2\u0114\u0115\7\61\2\2\u0115\u0119\3\2\2"+
		"\2\u0116\u0118\13\2\2\2\u0117\u0116\3\2\2\2\u0118\u011b\3\2\2\2\u0119"+
		"\u011a\3\2\2\2\u0119\u0117\3\2\2\2\u011a\u011d\3\2\2\2\u011b\u0119\3\2"+
		"\2\2\u011c\u011e\7\17\2\2\u011d\u011c\3\2\2\2\u011d\u011e\3\2\2\2\u011e"+
		"\u011f\3\2\2\2\u011f\u0120\7\f\2\2\u0120\u0121\3\2\2\2\u0121\u0122\b."+
		"\2\2\u0122\\\3\2\2\2\u0123\u0124\7\61\2\2\u0124\u0125\7,\2\2\u0125\u012a"+
		"\3\2\2\2\u0126\u0129\5]/\2\u0127\u0129\13\2\2\2\u0128\u0126\3\2\2\2\u0128"+
		"\u0127\3\2\2\2\u0129\u012c\3\2\2\2\u012a\u012b\3\2\2\2\u012a\u0128\3\2"+
		"\2\2\u012b\u012d\3\2\2\2\u012c\u012a\3\2\2\2\u012d\u012e\7,\2\2\u012e"+
		"\u012f\7\61\2\2\u012f\u0130\3\2\2\2\u0130\u0131\b/\2\2\u0131^\3\2\2\2"+
		"\21\2mo\u0098\u009a\u00a1\u00a3\u00ea\u00f1\u0104\u010f\u0119\u011d\u0128"+
		"\u012a\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}