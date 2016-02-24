package com.zjffdu.tutorial.zeppelin;

import org.apache.zeppelin.interpreter.Interpreter;
import org.apache.zeppelin.interpreter.InterpreterContext;
import org.apache.zeppelin.interpreter.InterpreterResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Properties;

/**
 * Created by jzhang on 2/5/16.
 */
public class TestInterpreter extends Interpreter {

  static final Logger LOGGER = LoggerFactory.getLogger(TestInterpreter.class);

  static {
    Interpreter.register("test", TestInterpreter.class.getName());
  }

  public TestInterpreter(Properties property) {
    super(property);
  }

  @Override
  public void open() {
    LOGGER.info("start TestInterpretor****************************");
  }

  @Override
  public void close() {

  }

  @Override
  public InterpreterResult interpret(String s, InterpreterContext interpreterContext) {
    String result = "hello " + s;
    return new InterpreterResult(InterpreterResult.Code.SUCCESS, result);
  }

  @Override
  public void cancel(InterpreterContext interpreterContext) {

  }

  @Override
  public FormType getFormType() {
    return FormType.SIMPLE;
  }

  @Override
  public int getProgress(InterpreterContext interpreterContext) {
    return 0;
  }

  @Override
  public List<String> completion(String s, int i) {
    return null;
  }
}
