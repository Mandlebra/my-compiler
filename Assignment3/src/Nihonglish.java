/* Generated By:JavaCC: Do not edit this line. Nihonglish.java */
import  java.util.*;
import  java.io.*;

public
class   Nihonglish implements NihonglishConstants {
    public
    static
    String      QUIT_CMD        = "";

    static
    Nihonglish  parser  = null;

    public
    static
    Sentence    parse           (String parseMe
                                )
                                throws Exception
    {
      StringReader      input   = new java.io.StringReader(parseMe);

      if  (parser == null)
        parser  = new Nihonglish(input);
      else
        parser.ReInit(input);

      return(parser.sentence());
    }


    public
    static
    void        main(String[] args) throws Exception
    {
      String    parseMe;
      Scanner   input   = new Scanner(System.in);

      while (true)
      {
        System.out.print
                ("Sentence to parse or \""      +
                 QUIT_CMD                       +
                 "\" to quit: "
                );

        parseMe = input.nextLine();

        if  ( parseMe.equals(QUIT_CMD) )
        {
          break;
        }

        try
        {
          System.out.println(parse(parseMe));
        }
        catch (Exception error)
        {
          System.err.println(error);
        }
      }
    }

  static final public Sentence sentence() throws ParseException, Exception {
  Sentence      sent;
  Phrase        phrase;
  boolean       isQuestion;
    phrase = postposit_phrase_list();
    jj_consume_token(GOING);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PERIOD:
      jj_consume_token(PERIOD);
                   isQuestion = false;
      break;
    case QUESTION_MARK:
      jj_consume_token(QUESTION_MARK);
                                                         isQuestion = true;
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
     {if (true) return (new Sentence(phrase, isQuestion));}
    throw new Error("Missing return statement in function");
  }

  static final public Phrase postposit_phrase_list() throws ParseException, Exception {
  Phrase        phrase1st       = null;
  Phrase        phraseNth       = null;
    phrase1st = postposit_phrase();
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case I:
      case YOU:
      case HOME:
      case STORE:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
      phraseNth = postposit_phrase();
    }
    phrase1st.attach(phraseNth);
    {if (true) return phrase1st;}
    throw new Error("Missing return statement in function");
  }

  static final public Phrase postposit_phrase() throws ParseException, Exception {
  Phrase        phrase  = null;
  String        who     = "";
  String        where   = "";
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case I:
    case YOU:
      who = who();
      jj_consume_token(AS);
      jj_consume_token(FOR);
                             phrase = new SubjectPhrase(who);
      break;
    case HOME:
    case STORE:
      where = where();
      jj_consume_token(TO);
                                                                                       phrase = new ToPhrase(where);
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
     {if (true) return(phrase);}
    throw new Error("Missing return statement in function");
  }

  static final public String who() throws ParseException, Exception {
  String        s;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case I:
      jj_consume_token(I);
           s = "I";
      break;
    case YOU:
      jj_consume_token(YOU);
                                s = "you";
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
     {if (true) return (s);}
    throw new Error("Missing return statement in function");
  }

  static final public String where() throws ParseException, Exception {
  String        s;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case HOME:
      jj_consume_token(HOME);
             s = "home";
      break;
    case STORE:
      jj_consume_token(STORE);
                                     s = "the store";
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
   {if (true) return (s);}
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public NihonglishTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[5];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x6000,0x1860,0x1860,0x60,0x1800,};
   }

  /** Constructor with InputStream. */
  public Nihonglish(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Nihonglish(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new NihonglishTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Nihonglish(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new NihonglishTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Nihonglish(NihonglishTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(NihonglishTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List jj_expentries = new java.util.ArrayList();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[15];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 5; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 15; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}