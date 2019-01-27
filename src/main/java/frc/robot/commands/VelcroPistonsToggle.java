package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

/**
 * Add description here
 */
public class VelcroPistonsToggle extends Command
{

	public VelcroPistonsToggle()
	{
		requires(Robot.VelcroPistons);
	}

	protected void initialize()
	{

	}

	protected void execute()
	{
		Robot.VelcroPistons.PistonsOut(Robot.OI.getJoystickBran());
		SmartDashboard.putBoolean("isVelcroPistonLeftOut", true);
		SmartDashboard.putBoolean("isVelcroPistonRightOut", true);
	}

	protected boolean isFinished()
	{
		return true;
	}

	protected void end()
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Robot.VelcroPistons.PistonsIn(Robot.OI.getJoystickBran());
		SmartDashboard.putBoolean("isVelcroPistonLeftOut", false);
		SmartDashboard.putBoolean("isVelcroPistonRightOut", false);
	}

	protected void interrupted()
	{
	}

}
