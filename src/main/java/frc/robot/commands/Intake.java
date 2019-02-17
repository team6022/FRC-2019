package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class Intake extends Command
{

	Double _Speed = 0.0;

	/**
	* Intake toggles ball intake
	*
	* @param speed what direction to turn - Positive speed means take ball in, negative means shoot ball out
	*/
	public Intake(Double Speed)
	{
		_Speed = Speed;
		requires(Robot.ExtendingArm);
	}

	protected void initialize()
	{
	}

	protected void execute()
	{
		Robot.Intake.IntakeBall(_Speed);
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