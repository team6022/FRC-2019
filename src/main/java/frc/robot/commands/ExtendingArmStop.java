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


		Robot.ExtendingArm.Stop();
	}

	protected boolean isFinished()
	{
			if (TalonLeft.getSelectedSensorPosition() >= 0) {

				// reset back to zero
				TalonLeft.setSelectedSensorPosition(0);

				return true;
			} else {
				return false;
			}
	}

	protected void end()
	{
	}

	protected void interrupted()
	{
	}

}
