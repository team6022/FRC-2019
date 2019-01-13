package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class VelcroPistonsToggle extends Command {

	public VelcroPistonsToggle()
	{
		requires(Robot.VelcroPistons);
	}

	protected void initialize()
	{
        
	}

	protected void execute()
	{
        Robot.VelcroPistons.PistonOut(Robot.OI.getJoystickBran());
        SmartDashboard.putBoolean("isVelcroPistonOut", true);
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Robot.VelcroPistons.PistonIn(Robot.OI.getJoystickBran());
        SmartDashboard.putBoolean("isVelcroPistonOut", false);
	}

	protected void interrupted() {
	}

}
