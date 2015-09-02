package com.songo.gather.log;

import org.apache.log4j.Level;

/**
 * <p>日志工具</p>
 *
 * @author gaobaowen
 * @since 1.0.0
 */
public interface Log {

    /**
     * <p>获取日志记录器的名称</p>
     *
     * @return 日志记录器的名称
     */
    String getName();

    /**
     * <p>检查是否启用 {@link Level#TRACE TRACE} 级别日志</p>
     *
     * @return 是否启用 {@link Level#TRACE TRACE} 级别日志
     */
    boolean isTraceEnabled();

    /**
     * <p>检查是否启用 {@link Level#DEBUG DEBUG} 级别日志</p>
     *
     * @return 是否启用 {@link Level#DEBUG DEBUG} 级别日志
     */
    boolean isDebugEnabled();

    /**
     * <p>检查是否启用 {@link Level#INFO INFO} 级别日志</p>
     *
     * @return 是否启用 {@link Level#INFO INFO} 级别日志
     */
    boolean isInfoEnabled();

    /**
     * <p>检查是否启用 {@link Level#WARN WARN} 级别日志</p>
     *
     * @return 是否启用 {@link Level#WARN WARN} 级别日志
     */
    boolean isWarnEnabled();

    /**
     * <p>检查是否启用 {@link Level#ERROR ERROR} 级别日志</p>
     *
     * @return 是否启用 {@link Level#ERROR ERROR} 级别日志
     */
    boolean isErrorEnabled();

    /**
     * <p>检查是否启用 {@link Level#FATAL FATAL} 级别日志</p>
     *
     * @return 是否启用 {@link Level#FATAL FATAL} 级别日志
     */
    boolean isFatalEnabled();

    /**
     * <p>检查是否启用指定级别的日志</p>
     *
     * @return 是否启用指定的级别日志
     */
    boolean isEnabled(Level level);


    /**
     * <p>记录 {@link Level#TRACE TRACE} 级别的日志。</p>
     *
     * <p>具体是否输出日志，会依赖于 {@link #isTraceEnabled()} 是否启用该别的日志记录器</p>
     *
     * @param message 日志消息
     */
    void trace(String message);

    /**
     * <p>记录 {@link Level#TRACE TRACE} 级别的日志。</p>
     *
     * <p>具体是否输出日志，会依赖于 {@link #isTraceEnabled()} 是否启用该别的日志记录器</p>
     *
     * @param pattern 日志消息模板，占位符使用“{}”表示
     * @param arg 占位符参数。如果不存在占位符，且该参数类型为 {@link Throwable} 时，将输出异常堆栈信息。
     *      如果占位符有一个，该参数作为普通对象的 {@link String#valueOf(Object)} 进行输出
     */
    void trace(String pattern, Object arg);

    /**
     * <p>记录 {@link Level#TRACE TRACE} 级别的日志。</p>
     *
     * <p>具体是否输出日志，会依赖于 {@link #isTraceEnabled()} 是否启用该别的日志记录器</p>
     *
     * @param pattern 日志消息模板，占位符使用“{}”表示
     * @param arg0 占位符参数
     * @param arg1 占位符参数。如果占位符仅有一个，且该参数类型为 {@link Throwable} 时，将输出异常堆栈信息。
     *      如果占位符有两个，该参数作为普通对象的 {@link String#valueOf(Object)} 进行输出
     */
    void trace(String pattern, Object arg0, Object arg1);

    /**
     * <p>记录 {@link Level#TRACE TRACE} 级别的日志。</p>
     *
     * <p>具体是否输出日志，会依赖于 {@link #isTraceEnabled()} 是否启用该别的日志记录器</p>
     *
     * @param pattern 日志消息模板，占位符使用“{}”表示
     * @param arg0 占位符参数
     * @param arg1 占位符参数
     * @param arg2 占位符参数。如果占位符仅有两个，且该参数类型为 {@link Throwable} 时，将输出异常堆栈信息。
     *      如果占位符有三个，该参数作为普通对象的 {@link String#valueOf(Object)} 进行输出
     */
    void trace(String pattern, Object arg0, Object arg1, Object arg2);

    /**
     * <p>记录 {@link Level#TRACE TRACE} 级别的日志。</p>
     *
     * <p>具体是否输出日志，会依赖于 {@link #isTraceEnabled()} 是否启用该别的日志记录器</p>
     *
     * @param pattern 日志消息模板，占位符使用“{}”表示
     * @param args 如果占位符的个数小于该参数的长度时，且该参数类型为 {@link Throwable} 时，将输出异常堆栈信息。
     *      如果该参数长度与占位符个数一致时，该参数作为普通对象的 {@link String#valueOf(Object)} 进行输出
     */
    void trace(String pattern, Object... args);


    /**
     * <p>记录 {@link Level#DEBUG DEBUG} 级别的日志。</p>
     *
     * <p>具体是否输出日志，会依赖于 {@link #isDebugEnabled()} 是否启用该别的日志记录器</p>
     *
     * @param message 日志消息
     */
    void debug(String message);

    /**
     * <p>记录 {@link Level#DEBUG DEBUG} 级别的日志。</p>
     *
     * <p>具体是否输出日志，会依赖于 {@link #isDebugEnabled()} 是否启用该别的日志记录器</p>
     *
     * @param pattern 日志消息模板，占位符使用“{}”表示
     * @param arg 占位符参数。如果不存在占位符，且该参数类型为 {@link Throwable} 时，将输出异常堆栈信息。
     *      如果占位符有一个，该参数作为普通对象的 {@link String#valueOf(Object)} 进行输出
     */
    void debug(String pattern, Object arg);

    /**
     * <p>记录 {@link Level#DEBUG DEBUG} 级别的日志。</p>
     *
     * <p>具体是否输出日志，会依赖于 {@link #isDebugEnabled()} 是否启用该别的日志记录器</p>
     *
     * @param pattern 日志消息模板，占位符使用“{}”表示
     * @param arg0 占位符参数
     * @param arg1 占位符参数。如果占位符仅有一个，且该参数类型为 {@link Throwable} 时，将输出异常堆栈信息。
     *      如果占位符有两个，该参数作为普通对象的 {@link String#valueOf(Object)} 进行输出
     */
    void debug(String pattern, Object arg0, Object arg1);

    /**
     * <p>记录 {@link Level#DEBUG DEBUG} 级别的日志。</p>
     *
     * <p>具体是否输出日志，会依赖于 {@link #isDebugEnabled()} 是否启用该别的日志记录器</p>
     *
     * @param pattern 日志消息模板，占位符使用“{}”表示
     * @param arg0 占位符参数
     * @param arg1 占位符参数
     * @param arg2 占位符参数。如果占位符仅有两个，且该参数类型为 {@link Throwable} 时，将输出异常堆栈信息。
     *      如果占位符有三个，该参数作为普通对象的 {@link String#valueOf(Object)} 进行输出
     */
    void debug(String pattern, Object arg0, Object arg1, Object arg2);

    /**
     * <p>记录 {@link Level#DEBUG DEBUG} 级别的日志。</p>
     *
     * <p>具体是否输出日志，会依赖于 {@link #isDebugEnabled()} 是否启用该别的日志记录器</p>
     *
     * @param pattern 日志消息模板，占位符使用“{}”表示
     * @param args 如果占位符的个数小于该参数的长度时，且该参数类型为 {@link Throwable} 时，将输出异常堆栈信息。
     *      如果该参数长度与占位符个数一致时，该参数作为普通对象的 {@link String#valueOf(Object)} 进行输出
     */
    void debug(String pattern, Object... args);


    /**
     * <p>记录 {@link Level#INFO INFO} 级别的日志。</p>
     *
     * <p>具体是否输出日志，会依赖于 {@link #isInfoEnabled()} 是否启用该别的日志记录器</p>
     *
     * @param message 日志消息
     */
    void info(String message);

    /**
     * <p>记录 {@link Level#INFO INFO} 级别的日志。</p>
     *
     * <p>具体是否输出日志，会依赖于 {@link #isInfoEnabled()} 是否启用该别的日志记录器</p>
     *
     * @param pattern 日志消息模板，占位符使用“{}”表示
     * @param arg 占位符参数。如果不存在占位符，且该参数类型为 {@link Throwable} 时，将输出异常堆栈信息。
     *      如果占位符有一个，该参数作为普通对象的 {@link String#valueOf(Object)} 进行输出
     */
    void info(String pattern, Object arg);

    /**
     * <p>记录 {@link Level#INFO INFO} 级别的日志。</p>
     *
     * <p>具体是否输出日志，会依赖于 {@link #isInfoEnabled()} 是否启用该别的日志记录器</p>
     *
     * @param pattern 日志消息模板，占位符使用“{}”表示
     * @param arg0 占位符参数
     * @param arg1 占位符参数。如果占位符仅有一个，且该参数类型为 {@link Throwable} 时，将输出异常堆栈信息。
     *      如果占位符有两个，该参数作为普通对象的 {@link String#valueOf(Object)} 进行输出
     */
    void info(String pattern, Object arg0, Object arg1);

    /**
     * <p>记录 {@link Level#INFO INFO} 级别的日志。</p>
     *
     * <p>具体是否输出日志，会依赖于 {@link #isInfoEnabled()} 是否启用该别的日志记录器</p>
     *
     * @param pattern 日志消息模板，占位符使用“{}”表示
     * @param arg0 占位符参数
     * @param arg1 占位符参数
     * @param arg2 占位符参数。如果占位符仅有两个，且该参数类型为 {@link Throwable} 时，将输出异常堆栈信息。
     *      如果占位符有三个，该参数作为普通对象的 {@link String#valueOf(Object)} 进行输出
     */
    void info(String pattern, Object arg0, Object arg1, Object arg2);

    /**
     * <p>记录 {@link Level#INFO INFO} 级别的日志。</p>
     *
     * <p>具体是否输出日志，会依赖于 {@link #isInfoEnabled()} 是否启用该别的日志记录器</p>
     *
     * @param pattern 日志消息模板，占位符使用“{}”表示
     * @param args 如果占位符的个数小于该参数的长度时，且该参数类型为 {@link Throwable} 时，将输出异常堆栈信息。
     *      如果该参数长度与占位符个数一致时，该参数作为普通对象的 {@link String#valueOf(Object)} 进行输出
     */
    void info(String pattern, Object... args);


    /**
     * <p>记录 {@link Level#WARN WARN} 级别的日志。</p>
     *
     * <p>具体是否输出日志，会依赖于 {@link #isWarnEnabled()} 是否启用该别的日志记录器</p>
     *
     * @param message 日志消息
     */
    void warn(String message);

    /**
     * <p>记录 {@link Level#WARN WARN} 级别的日志。</p>
     *
     * <p>具体是否输出日志，会依赖于 {@link #isWarnEnabled()} 是否启用该别的日志记录器</p>
     *
     * @param pattern 日志消息模板，占位符使用“{}”表示
     * @param arg 占位符参数。如果不存在占位符，且该参数类型为 {@link Throwable} 时，将输出异常堆栈信息。
     *      如果占位符有一个，该参数作为普通对象的 {@link String#valueOf(Object)} 进行输出
     */
    void warn(String pattern, Object arg);

    /**
     * <p>记录 {@link Level#WARN WARN} 级别的日志。</p>
     *
     * <p>具体是否输出日志，会依赖于 {@link #isWarnEnabled()} 是否启用该别的日志记录器</p>
     *
     * @param pattern 日志消息模板，占位符使用“{}”表示
     * @param arg0 占位符参数
     * @param arg1 占位符参数。如果占位符仅有一个，且该参数类型为 {@link Throwable} 时，将输出异常堆栈信息。
     *      如果占位符有两个，该参数作为普通对象的 {@link String#valueOf(Object)} 进行输出
     */
    void warn(String pattern, Object arg0, Object arg1);

    /**
     * <p>记录 {@link Level#WARN WARN} 级别的日志。</p>
     *
     * <p>具体是否输出日志，会依赖于 {@link #isWarnEnabled()} 是否启用该别的日志记录器</p>
     *
     * @param pattern 日志消息模板，占位符使用“{}”表示
     * @param arg0 占位符参数
     * @param arg1 占位符参数
     * @param arg2 占位符参数。如果占位符仅有两个，且该参数类型为 {@link Throwable} 时，将输出异常堆栈信息。
     *      如果占位符有三个，该参数作为普通对象的 {@link String#valueOf(Object)} 进行输出
     */
    void warn(String pattern, Object arg0, Object arg1, Object arg2);

    /**
     * <p>记录 {@link Level#WARN WARN} 级别的日志。</p>
     *
     * <p>具体是否输出日志，会依赖于 {@link #isWarnEnabled()} 是否启用该别的日志记录器</p>
     *
     * @param pattern 日志消息模板，占位符使用“{}”表示
     * @param args 如果占位符的个数小于该参数的长度时，且该参数类型为 {@link Throwable} 时，将输出异常堆栈信息。
     *      如果该参数长度与占位符个数一致时，该参数作为普通对象的 {@link String#valueOf(Object)} 进行输出
     */
    void warn(String pattern, Object... args);


    /**
     * <p>记录 {@link Level#ERROR ERROR} 级别的日志。</p>
     *
     * <p>具体是否输出日志，会依赖于 {@link #isErrorEnabled()} 是否启用该别的日志记录器</p>
     *
     * @param message 日志消息
     */
    void error(String message);

    /**
     * <p>记录 {@link Level#ERROR ERROR} 级别的日志。</p>
     *
     * <p>具体是否输出日志，会依赖于 {@link #isErrorEnabled()} 是否启用该别的日志记录器</p>
     *
     * @param pattern 日志消息模板，占位符使用“{}”表示
     * @param arg 占位符参数。如果不存在占位符，且该参数类型为 {@link Throwable} 时，将输出异常堆栈信息。
     *      如果占位符有一个，该参数作为普通对象的 {@link String#valueOf(Object)} 进行输出
     */
    void error(String pattern, Object arg);

    /**
     * <p>记录 {@link Level#ERROR ERROR} 级别的日志。</p>
     *
     * <p>具体是否输出日志，会依赖于 {@link #isErrorEnabled()} 是否启用该别的日志记录器</p>
     *
     * @param pattern 日志消息模板，占位符使用“{}”表示
     * @param arg0 占位符参数
     * @param arg1 占位符参数。如果占位符仅有一个，且该参数类型为 {@link Throwable} 时，将输出异常堆栈信息。
     *      如果占位符有两个，该参数作为普通对象的 {@link String#valueOf(Object)} 进行输出
     */
    void error(String pattern, Object arg0, Object arg1);

    /**
     * <p>记录 {@link Level#ERROR ERROR} 级别的日志。</p>
     *
     * <p>具体是否输出日志，会依赖于 {@link #isErrorEnabled()} 是否启用该别的日志记录器</p>
     *
     * @param pattern 日志消息模板，占位符使用“{}”表示
     * @param arg0 占位符参数
     * @param arg1 占位符参数
     * @param arg2 占位符参数。如果占位符仅有两个，且该参数类型为 {@link Throwable} 时，将输出异常堆栈信息。
     *      如果占位符有三个，该参数作为普通对象的 {@link String#valueOf(Object)} 进行输出
     */
    void error(String pattern, Object arg0, Object arg1, Object arg2);

    /**
     * <p>记录 {@link Level#ERROR ERROR} 级别的日志。</p>
     *
     * <p>具体是否输出日志，会依赖于 {@link #isErrorEnabled()} 是否启用该别的日志记录器</p>
     *
     * @param pattern 日志消息模板，占位符使用“{}”表示
     * @param args 如果占位符的个数小于该参数的长度时，且该参数类型为 {@link Throwable} 时，将输出异常堆栈信息。
     *      如果该参数长度与占位符个数一致时，该参数作为普通对象的 {@link String#valueOf(Object)} 进行输出
     */
    void error(String pattern, Object... args);


    /**
     * <p>记录 {@link Level#FATAL FATAL} 级别的日志。</p>
     *
     * <p>具体是否输出日志，会依赖于 {@link #isFatalEnabled()} 是否启用该别的日志记录器</p>
     *
     * @param message 日志消息
     */
    void fatal(String message);

    /**
     * <p>记录 {@link Level#FATAL FATAL} 级别的日志。</p>
     *
     * <p>具体是否输出日志，会依赖于 {@link #isFatalEnabled()} 是否启用该别的日志记录器</p>
     *
     * @param pattern 日志消息模板，占位符使用“{}”表示
     * @param arg 占位符参数。如果不存在占位符，且该参数类型为 {@link Throwable} 时，将输出异常堆栈信息。
     *      如果占位符有一个，该参数作为普通对象的 {@link String#valueOf(Object)} 进行输出
     */
    void fatal(String pattern, Object arg);

    /**
     * <p>记录 {@link Level#FATAL FATAL} 级别的日志。</p>
     *
     * <p>具体是否输出日志，会依赖于 {@link #isFatalEnabled()} 是否启用该别的日志记录器</p>
     *
     * @param pattern 日志消息模板，占位符使用“{}”表示
     * @param arg0 占位符参数
     * @param arg1 占位符参数。如果占位符仅有一个，且该参数类型为 {@link Throwable} 时，将输出异常堆栈信息。
     *      如果占位符有两个，该参数作为普通对象的 {@link String#valueOf(Object)} 进行输出
     */
    void fatal(String pattern, Object arg0, Object arg1);

    /**
     * <p>记录 {@link Level#FATAL FATAL} 级别的日志。</p>
     *
     * <p>具体是否输出日志，会依赖于 {@link #isFatalEnabled()} 是否启用该别的日志记录器</p>
     *
     * @param pattern 日志消息模板，占位符使用“{}”表示
     * @param arg0 占位符参数
     * @param arg1 占位符参数
     * @param arg2 占位符参数。如果占位符仅有两个，且该参数类型为 {@link Throwable} 时，将输出异常堆栈信息。
     *      如果占位符有三个，该参数作为普通对象的 {@link String#valueOf(Object)} 进行输出
     */
    void fatal(String pattern, Object arg0, Object arg1, Object arg2);

    /**
     * <p>记录 {@link Level#FATAL FATAL} 级别的日志。</p>
     *
     * <p>具体是否输出日志，会依赖于 {@link #isFatalEnabled()} 是否启用该别的日志记录器</p>
     *
     * @param pattern 日志消息模板，占位符使用“{}”表示
     * @param args 如果占位符的个数小于该参数的长度时，且该参数类型为 {@link Throwable} 时，将输出异常堆栈信息。
     *      如果该参数长度与占位符个数一致时，该参数作为普通对象的 {@link String#valueOf(Object)} 进行输出
     */
    void fatal(String pattern, Object... args);


    /**
     * <p>记录指定级别的日志。</p>
     *
     * <p>具体是否输出日志，会依赖于 {@link Level#isEnabled(Log)} 是否启用该别的日志记录器</p>
     *
     * @param level 日志级别
     * @param message 日志消息
     */
    void log(Level level, String message);

    /**
     * <p>记录指定级别的日志。</p>
     *
     * <p>具体是否输出日志，会依赖于 {@link Level#isEnabled(Log)} 是否启用该别的日志记录器</p>
     *
     * @param level 日志级别
     * @param pattern 日志消息模板，占位符使用“{}”表示
     * @param arg 占位符参数。如果不存在占位符，且该参数类型为 {@link Throwable} 时，将输出异常堆栈信息。
     *      如果占位符有一个，该参数作为普通对象的 {@link String#valueOf(Object)} 进行输出
     */
    void log(Level level, String pattern, Object arg);

    /**
     * <p>记录指定级别的日志。</p>
     *
     * <p>具体是否输出日志，会依赖于 {@link Level#isEnabled(Log)} 是否启用该别的日志记录器</p>
     *
     * @param level 日志级别
     * @param pattern 日志消息模板，占位符使用“{}”表示
     * @param arg0 占位符参数
     * @param arg1 占位符参数。如果占位符仅有一个，且该参数类型为 {@link Throwable} 时，将输出异常堆栈信息。
     *      如果占位符有两个，该参数作为普通对象的 {@link String#valueOf(Object)} 进行输出
     */
    void log(Level level, String pattern, Object arg0, Object arg1);

    /**
     * <p>记录指定级别的日志。</p>
     *
     * <p>具体是否输出日志，会依赖于 {@link Level#isEnabled(Log)} 是否启用该别的日志记录器</p>
     *
     * @param level 日志级别
     * @param pattern 日志消息模板，占位符使用“{}”表示
     * @param arg0 占位符参数
     * @param arg1 占位符参数
     * @param arg2 占位符参数。如果占位符仅有两个，且该参数类型为 {@link Throwable} 时，将输出异常堆栈信息。
     *      如果占位符有三个，该参数作为普通对象的 {@link String#valueOf(Object)} 进行输出
     */
    void log(Level level, String pattern, Object arg0, Object arg1, Object arg2);

    /**
     * <p>记录指定级别的日志。</p>
     *
     * <p>具体是否输出日志，会依赖于 {@link Level#isEnabled(Log)} 是否启用该别的日志记录器</p>
     *
     * @param level 日志级别
     * @param pattern 日志消息模板，占位符使用“{}”表示
     * @param args 如果占位符的个数小于该参数的长度时，且该参数类型为 {@link Throwable} 时，将输出异常堆栈信息。
     *      如果该参数长度与占位符个数一致时，该参数作为普通对象的 {@link String#valueOf(Object)} 进行输出
     */
    void log(Level level, String pattern, Object... args);
}
