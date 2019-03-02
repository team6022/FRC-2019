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
	Double direction = 1.0;


	public ExtendingArmMovePosition(Integer _positionNew)
	{
		requires(Robot.ExtendingArm);

		positionNew = _positionNew;
		positionCurrent = TalonLeft.getSelectedSensorPosition();

		// check to see if the arm should be going up or down
		if (positionNew < positionCurrent) direction = -1.0;

	}

	protected void initialize()
	{
	}

	protected void execute()
	{
		Robot.ExtendingArm.Move(0.40 * direction);
	}

	protected boolean isFinished()
	{
		// stop running command only when the left talon is equal to the position that was set
		if (direction == 1.0) {
			return TalonLeft.getSelectedSensorPosition() >= positionNew;
		} else {
			return TalonLeft.getSelectedSensorPosition() <= positionNew;
		}

	}

	protected void end()
	{
	}

	protected void interrupted()
	{
	}

}
