package com.fangj.exercise.antlr4;

/**
 * @author fangjie
 * @date Created in 下午6:34 18/8/21.
 */
public class HelloWalker extends HelloBaseListener {
    @Override
    public void enterR(HelloParser.RContext ctx) {
        System.out.println("Entering R : " + ctx.ID().getText());
    }

    @Override
    public void exitR(HelloParser.RContext ctx) {
        System.out.println("Exiting R");
    }
}
