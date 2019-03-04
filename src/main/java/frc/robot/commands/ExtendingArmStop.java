package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;



public class ExtendingArmStop extends Command
{

	static TalonSRX TalonLeft = new TalonSRX(RobotMap.ExtendingArmLeft);

	Integer positionNew = 0;
	Integer positionCurrent = 0;
	Double direction = -1.0;


	public ExtendingArmStop()
	{
		requires(Robot.ExtendingArm);
	}

	protected void initialize()
	{
	}

	protected void execute()
	{
		// pass in -1 will make the arm go down
		Robot.ExtendingArm.Move(-1);
	}

	protected boolean isFinished()
	{
		// make sure the command keeps running until the position of the left are is 0 or lower
		return TalonLeft.getSelectedSensorPosition() >= 0;
	}

	protected void end()
	{
		// reset back to zero
		// We need to do this because sometimes the chain slack causes this to end somewhere between 0-50.
		TalonLeft.setSelectedSensorPosition(0);
	}

	protected void interrupted()
	{
	}

}
