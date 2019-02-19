package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;



public class RecordStart extends Command
{

	public RecordStart()
	{

	}

	protected void initialize()
	{
	}

	protected void execute()
	{
		Shuffleboard.startRecording();
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