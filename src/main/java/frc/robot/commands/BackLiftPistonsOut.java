package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

/**
 * Add description here
 */
public class BackLiftPistonsOut extends Command
{

	public BackLiftPistonsOut()
	{
		requires(Robot.LiftPistons);
	}

	protected void initialize()
	{

	}

	protected void execute()
	{
		Robot.LiftPistons.BackPistonsOut(Robot.OI.getJoystickBran());
		SmartDashboard.putBoolean("BackLiftPistonsOut", true);
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
