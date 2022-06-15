package stind;

public class Result<T, S extends Exception>
{
	private boolean type;
	private T val;
	private S err;

	public Result(T value) {
		type = false;
		val = value;
	}

	public Result(S error) {
		type = true;
		err = error;
	}

	public T unwrap() throws Exception {
		if (type) throw err;
		return val;
	}

	public <E extends ErrorHandler> T unwrap_or(E error_handler) {
		if (type) {
			error_handler.run(err);
			return null;
		}
		return val;
	}
}

/* let nombre = stind.read_line().unwrap(); // nombre = Result<String, IOException>
*/
