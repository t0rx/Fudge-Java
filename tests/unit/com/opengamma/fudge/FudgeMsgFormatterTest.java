/**
 * Copyright (C) 2009 - 2009 by OpenGamma Inc.
 *
 * Please see distribution for license.
 */
package com.opengamma.fudge;

import java.io.PrintWriter;

import org.junit.Test;

/**
 * 
 *
 * @author kirk
 */
public class FudgeMsgFormatterTest {
  
  /**
   * Will output a {@link FudgeMsg} to {@code System.out} so that you can visually
   * examine it.
   */
  @Test
  public void outputToStdoutAllNames() {
    System.out.println("FudgeMsgFormatterTest.outputToStdoutAllNames()");
    FudgeMsg msg = FudgeMsgTest.createMessageAllNames();
    msg.add(FudgeMsgTest.createMessageAllNames(), "Sub Message", (short)9999);
    (new FudgeMsgFormatter(new PrintWriter(System.out))).format(msg);
  }
  
  /**
   * Will output a {@link FudgeMsg} to {@code System.out} so that you can visually
   * examine it.
   */
  @Test
  public void outputToStdoutAllOrdinals() {
    System.out.println("FudgeMsgFormatterTest.outputToStdoutAllOrdinals()");
    FudgeMsg msg = FudgeMsgTest.createMessageAllOrdinals();
    msg.add(FudgeMsgTest.createMessageAllOrdinals(), "Sub Message", (short)9999);
    (new FudgeMsgFormatter(new PrintWriter(System.out))).format(msg);
  }

}