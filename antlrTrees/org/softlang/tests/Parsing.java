package org.softlang.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import org.junit.Test;
// import static org.junit.Assert.*;
import org.softlang.parser.CompanyLexer;
import org.softlang.parser.CompanyParser;
import org.softlang.parser.CompanyParser.company_return;

public class Parsing {

	private static String posSample =
		"inputs" + File.separator + "sample.Company";
	private static String negSample =
		"inputs" + File.separator + "nonSample.Company";
		
	private static void parseCompany(String s) throws IOException, RecognitionException {
		FileInputStream stream = new FileInputStream(s);
        ANTLRInputStream antlr = new ANTLRInputStream(stream);
        CompanyLexer lexer = new CompanyLexer(antlr);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CompanyParser parser = new CompanyParser(tokens);
        
        company_return r = parser.company();
        if (parser.error) throw new RecognitionException();

        // Write out as string
        if ( r.getTree()!=null ) {
            System.out.println(((Tree)r.getTree()).toStringTree());
            ((CommonTree)r.getTree()).sanityCheckParentAndChildIndexes();
        }
        
        // Tree walk-based and indentation-aware output
        CommonTree tree = (CommonTree)r.getTree();
        printTree(tree, 0);
	}	
	
	@Test
	public void testPositive() throws IOException, RecognitionException {
		parseCompany(posSample);
    }       

	@Test(expected=RecognitionException.class)
	public void testNegative() throws IOException, RecognitionException {
		parseCompany(negSample);
    }       

	private static void printTree(CommonTree t, int indent) {
		if ( t != null ) {
			StringBuffer sb = new StringBuffer(indent);
			for ( int i = 0; i < indent; i++ )
				sb = sb.append("   ");
			for ( int i = 0; i < t.getChildCount(); i++ ) {
				System.out.println(sb.toString() + t.getChild(i).toString());
				printTree((CommonTree)t.getChild(i), indent+1);
			}
		}
	}		
}
