package parser;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;
import java.io.StringReader;

/**
 * The <code>Scanner</code> class can be used to read an input stream or a
 * <code>String</code> and to find "tokens" in a statement logic expression,
 * allowing the tokens to be read one at a time. The scanner can recognise
 * variables, and the following operators: <code>'!'</code>, <code>'&'</code>,
 * <code>'|'</code> and <code>"->"</code>. A variable is a string starting with
 * a letter and followed by zero or more letters and digits as defined by
 * <code>Character.isLetter(char)</code> and
 * <code>Character.isDigit(char)</code>.
 * 
 * Whitespace as defined by <code>Character.isWhitespace(char)</code> may be
 * used as a separator but it is skipped.
 */
public class Scanner {
    /**
     * Constants indicating what token has been read.
     * 
     * <ul>
     * <li>EOF = -1 : End of file
     * <li>VARIABLE = -2 : A variable
     * <li>IMPLIES = -3 : "->"
     * </ul>
     * 
     * A positive value indicates the ASCII code for a single character token.
     * 
     */
    public static final int EOF = -1, VARIABLE = -2, IMPLIES = -3;
    private PushbackReader reader;
    private String token;

    /**
     * Create a scanner that parses the given character stream.
     * 
     * @param reader
     *            a Reader object providing the input stream.
     */
    public Scanner(Reader reader) {
        this.reader = new PushbackReader(reader, 2);
    }

    /**
     * Create a scanner that parses the given string.
     * 
     * @param string
     *            a String object providing the input stream.
     */
    public Scanner(String string) {
        this(new StringReader(string));
    }

    /**
     * Parses the next token from the input stream of this scanner. The type of
     * the next token is returned. The token string is returned by the
     * <code>token()</code> method. If the type is positive it is character code
     * of a one character token. Otherwise it is defined by the public
     * constants.
     */
    public int nextToken() {
        try {
            return next();
        } catch (IOException e) {
            throw new ParserException(e.getMessage());
        }
    }

    private int next() throws IOException {
        token = null;
        int ch;
        do {
            ch = reader.read();
        } while (Character.isWhitespace(ch));
        if (Character.isLetter(ch)) {
            StringBuilder builder = new StringBuilder();
            do {
                builder.append((char) ch);
                ch = reader.read();
            } while (Character.isLetter(ch) || Character.isDigit(ch));
            if (ch != EOF) {
                reader.unread(ch);
            }
            token = builder.toString();
            return VARIABLE;
        }
        if (ch == '-') {
            ch = reader.read();
            if (ch == '>') {
                token = "->";
                return IMPLIES;
            } else if (ch != EOF) {
                reader.unread(ch);
            }
            ch = '-';
        }
        if (ch == EOF) {
            token = "EOF";
            return EOF;
        }
        token = String.valueOf((char) ch);
        return ch;
    }

    /**
     * Returns the string representation of the current token
     */
    public String token() {
        return token;
    }
}
