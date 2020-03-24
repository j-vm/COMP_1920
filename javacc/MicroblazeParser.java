/* MicroblazeParser.java */
/* Generated By:JJTree&JavaCC: Do not edit this line. MicroblazeParser.java */
public class MicroblazeParser/*@bgen(jjtree)*/implements MicroblazeParserTreeConstants, MicroblazeParserConstants {/*@bgen(jjtree)*/
  protected static JJTMicroblazeParserState jjtree = new JJTMicroblazeParserState();public static void main(String args[]) throws ParseException {
              System.out.println("Parser for Microblaze processor");
              MicroblazeParser myCalc = new MicroblazeParser(System.in);
              SimpleNode root = myCalc.Expression(); // returns reference to root node
              root.dump(""); // prints the tree on the screen
       }

  static final public SimpleNode Expression() throws ParseException {/*@bgen(jjtree) Expression */
  SimpleNode jjtn000 = new SimpleNode(JJTEXPRESSION);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      FullTrace();
      jj_consume_token(LF);
      jj_consume_token(0);
jjtree.closeNodeScope(jjtn000, true);
                                jjtc000 = false;
{if ("" != null) return jjtn000;}
    } catch (Throwable jjte000) {
if (jjtc000) {
           jjtree.clearNodeScope(jjtn000);
           jjtc000 = false;
         } else {
           jjtree.popNode();
         }
         if (jjte000 instanceof RuntimeException) {
           {if (true) throw (RuntimeException)jjte000;}
         }
         if (jjte000 instanceof ParseException) {
           {if (true) throw (ParseException)jjte000;}
         }
         {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
           jjtree.closeNodeScope(jjtn000, true);
         }
    }
    throw new Error("Missing return statement in function");
  }

  static final public void FullTrace() throws ParseException {
    label_1:
    while (true) {
      Line();
      jj_consume_token(LF);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case ADDRESS:{
        ;
        break;
        }
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
    }
  }

  static final public void Line() throws ParseException {Token t;
    t = jj_consume_token(ADDRESS);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case INSTRUCTION_A1:
    case INSTRUCTION_A2:
    case INSTRUCTION_A3:
    case INSTRUCTION_B1:
    case INSTRUCTION_B2:
    case INSTRUCTION_B3:{
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case INSTRUCTION_A1:{
        A1(t.image);
        break;
        }
      case INSTRUCTION_A2:{
        A2(t.image);
        break;
        }
      case INSTRUCTION_A3:{
        A3(t.image);
        break;
        }
      case INSTRUCTION_B1:{
        B1(t.image);
        break;
        }
      case INSTRUCTION_B2:{
        B2(t.image);
        break;
        }
      case INSTRUCTION_B3:{
        B3(t.image);
        break;
        }
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
      }
    default:
      jj_la1[2] = jj_gen;
      ;
    }
  }

  static final public void A1(String address) throws ParseException {/*@bgen(jjtree) A1 */
                              SimpleNode jjtn000 = new SimpleNode(JJTA1);
                              boolean jjtc000 = true;
                              jjtree.openNodeScope(jjtn000);jjtn000.address = address; Token instruction; Token register1;
    try {
      instruction = jj_consume_token(INSTRUCTION_A1);
jjtn000.instruction = instruction.image;
      register1 = jj_consume_token(REGISTER);
jjtree.closeNodeScope(jjtn000, true);
                          jjtc000 = false;
jjtn000.register1 = register1.image;
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  static final public void A2(String address) throws ParseException {/*@bgen(jjtree) A2 */
                              SimpleNode jjtn000 = new SimpleNode(JJTA2);
                              boolean jjtc000 = true;
                              jjtree.openNodeScope(jjtn000);jjtn000.address = address; Token instruction; Token register1; Token register2;
    try {
      instruction = jj_consume_token(INSTRUCTION_A2);
jjtn000.instruction = instruction.image;
      register1 = jj_consume_token(REGISTER);
jjtn000.register1 = register1.image;
      register2 = jj_consume_token(REGISTER);
jjtree.closeNodeScope(jjtn000, true);
                          jjtc000 = false;
jjtn000.register2 = register2.image;
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  static final public void A3(String address) throws ParseException {/*@bgen(jjtree) A3 */
                              SimpleNode jjtn000 = new SimpleNode(JJTA3);
                              boolean jjtc000 = true;
                              jjtree.openNodeScope(jjtn000);jjtn000.address = address; Token instruction; Token register1; Token register2; Token register3;
    try {
      instruction = jj_consume_token(INSTRUCTION_A3);
jjtn000.instruction = instruction.image;
      register1 = jj_consume_token(REGISTER);
jjtn000.register1 = register1.image;
      register2 = jj_consume_token(REGISTER);
jjtn000.register2 = register2.image;
      register3 = jj_consume_token(REGISTER);
jjtree.closeNodeScope(jjtn000, true);
                          jjtc000 = false;
jjtn000.register3 = register3.image;
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  static final public void B1(String address) throws ParseException {/*@bgen(jjtree) B1 */
                              SimpleNode jjtn000 = new SimpleNode(JJTB1);
                              boolean jjtc000 = true;
                              jjtree.openNodeScope(jjtn000);jjtn000.address = address; Token instruction; Token literal;
    try {
      instruction = jj_consume_token(INSTRUCTION_B1);
jjtn000.instruction = instruction.image;
      literal = jj_consume_token(LITERAL);
jjtree.closeNodeScope(jjtn000, true);
                       jjtc000 = false;
jjtn000.literal = literal.image;
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  static final public void B2(String address) throws ParseException {/*@bgen(jjtree) B2 */
                              SimpleNode jjtn000 = new SimpleNode(JJTB2);
                              boolean jjtc000 = true;
                              jjtree.openNodeScope(jjtn000);jjtn000.address = address; Token instruction; Token register1; Token literal;
    try {
      instruction = jj_consume_token(INSTRUCTION_B2);
jjtn000.instruction = instruction.image;
      register1 = jj_consume_token(REGISTER);
jjtn000.register1 = register1.image;
      literal = jj_consume_token(LITERAL);
jjtree.closeNodeScope(jjtn000, true);
                       jjtc000 = false;
jjtn000.literal = literal.image;
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  static final public void B3(String address) throws ParseException {/*@bgen(jjtree) B3 */
                              SimpleNode jjtn000 = new SimpleNode(JJTB3);
                              boolean jjtc000 = true;
                              jjtree.openNodeScope(jjtn000);jjtn000.address = address; Token instruction; Token register1; Token register2; Token literal;
    try {
      instruction = jj_consume_token(INSTRUCTION_B3);
jjtn000.instruction = instruction.image;
      register1 = jj_consume_token(REGISTER);
jjtn000.register1 = register1.image;
      register2 = jj_consume_token(REGISTER);
jjtn000.register2 = register2.image;
      literal = jj_consume_token(LITERAL);
jjtree.closeNodeScope(jjtn000, true);
                       jjtc000 = false;
jjtn000.literal = literal.image;
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public MicroblazeParserTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[3];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x10,0x7e0,0x7e0,};
   }

  /** Constructor with InputStream. */
  public MicroblazeParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public MicroblazeParser(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new MicroblazeParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
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
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public MicroblazeParser(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new MicroblazeParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public MicroblazeParser(MicroblazeParserTokenManager tm) {
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
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(MicroblazeParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
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

  static private int jj_ntk_f() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[14];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 3; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 14; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
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
