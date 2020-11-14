package br.unisinos.tradutores.custom;

import br.unisinos.tradutores.generated.ExprLexer;
import br.unisinos.tradutores.generated.ExprParser;
import org.antlr.v4.runtime.*;

import java.io.InputStream;
import java.util.Objects;


public class Test
{
	@org.junit.jupiter.api.Test
	public void testProgramParser() throws Exception {
		InputStream fileStream = Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("test.cc"));
		CharStream input = CharStreams.fromStream(fileStream);
		ExprLexer l = new ExprLexer(input);
		ExprParser p = new ExprParser(new CommonTokenStream(l));
		p.addErrorListener(new BaseErrorListener() {
			@Override
			public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
				throw new IllegalStateException("failed to parse at line " + line + " due to " + msg, e);
			}
		});
		p.program();
	}
}
