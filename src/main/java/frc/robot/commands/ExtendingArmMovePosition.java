package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;



public class ExtendingArmMovePosition extends Command
{

	static TalonSRX TalonLeft = new TalonSRX(RobotMap.ExtendingArmLeft);

	Integer positionNew = 0;
	Integer positionCurrent = 0;
	Double direction = -1.0;


	public ExtendingArmMovePosition(Integer _positionNew)
	{
		requires(Robot.ExtendingArm);

		positionNew = _positionNew;


	}

	protected void initialize()
	{
	}

	protected void execute()
	{
		positionCurrent = TalonLeft.getSelectedSensorPosition();

		// check to see if the arm should be going up or down
		if (positionNew < TalonLeft.getSelectedSensorPosition()) direction = 1.0;

		Robot.ExtendingArm.Move(direction);
	}

	protected boolean isFinished()
	{
		// stop running command only when the left talon is equal to the position that was set
		System.out.println("=======================================");

		System.out.println("current: " + positionCurrent);
		System.out.println("new: " + positionNew);
		System.out.println("direction: " + direction);


		if (direction == 1.0) {
			if (TalonLeft.getSelectedSensorPosition() <= positionNew) {
				return true;
			}
			return false;
		} else if (direction == -1.0) {
			if (TalonLeft.getSelectedSensorPosition() >= positionNew) {
				return true;
			}
			return false;
		} else {
			return true;
		}

	}

	protected void end()
	{
	}

	protected void interrupted()
	{
	}

}
