package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

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
		SmartDashboard.putBoolean("areLiftPistonsOut", false);
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
