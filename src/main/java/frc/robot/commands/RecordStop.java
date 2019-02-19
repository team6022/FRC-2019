package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;



public class RecordStop extends Command
{

	public RecordStop()
	{

	}

	protected void initialize()
	{
	}

	protected void execute()
	{
		Shuffleboard.stopRecording();
	}

	protected boolean isFinished()
	{
		return true;
	}

	protected void end()
	{
	}

	protected void interrupted()
	{
	}

}