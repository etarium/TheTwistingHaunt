package commandListener;

public class Reply {

	//the reply packages a success boolean as well as the string from the switch case.
	//in the case of movement, includes a bottom output as well as top output.
	//the boolean success value is used to determine if the Init class needs to continue running commands/
	public boolean isSuccess;
	public String output;
	public String upperOutput;
	
	public Reply(boolean isSuccess, String output) {
		this.isSuccess = isSuccess;
		this.output = output;
	}
	
	public Reply(boolean isSuccess, String output, String upperOutput) {
		this.isSuccess = isSuccess;
		this.output = output;
		this.upperOutput = upperOutput;
	}
}
