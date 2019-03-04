package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;



public class ExtendingArmMovePosition extends Command
{

	static TalonSRX TalonLeft = new TalonSRX(RobotMap.ExtendingArmLeft);

	Integer positionNew = 0;
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
		// check to see if the arm should be going up or down
		if (positionNew < TalonLeft.getSelectedSensorPosition()) direction = 1.0;

		Robot.ExtendingArm.Move(direction);
	}

	protected boolean isFinished()
	{

		// isFinished keeps checking to see if this command is ...well... finished.
		// Once a true bool is returned, this check ends and the command quits.
		// If false is returned, the command continues.

		// going up
		if (direction == 1.0) {
			return TalonLeft.getSelectedSensorPosition() <= positionNew;

		// going down
		} else if (direction == -1.0) {
			return TalonLeft.getSelectedSensorPosition() >= positionNew;

		// If we get here, somehow a direction was never passed in.
		// We don't want the command to run any longer, so we pass it a true to make it quit.
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
