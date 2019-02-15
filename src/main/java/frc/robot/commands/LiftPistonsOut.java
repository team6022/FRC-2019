package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

/**
 * Add description here
 */
public class LiftPistonsOut extends Command
{

	public LiftPistonsOut()
	{
		requires(Robot.VelcroPistons);
	}

	protected void initialize()
	{

	}

	protected void execute()
	{
		Robot.LiftPistons.PistonsOut(Robot.OI.getJoystickBran());
		SmartDashboard.putBoolean("areLiftPistonsOut", true);
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
