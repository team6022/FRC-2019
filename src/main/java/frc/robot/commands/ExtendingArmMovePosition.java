package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;


public class ExtendingArmMovePosition extends Command
{

	static TalonSRX TalonLeft = new TalonSRX(RobotMap.ExtendingArmLeft);

	// set some defaults, these will get swapped out below if needed
	Integer positionNew = 0;
	Double direction = -1.0; // Go up by default. Yeah, it's confusing. For some reason the signes got switched. (-) is up, (+) is down

	public ExtendingArmMovePosition(Integer _positionNew)
	{
		positionNew = _positionNew;
		requires(Robot.ExtendingArm);
	}

	protected void initialize()
	{
	}

	protected void execute()
	{
		// if the arm's current position is greater than where we want the arm to be, switch the direction to down
		if (positionNew < TalonLeft.getSelectedSensorPosition()) direction = 1.0;

		// run move
		Robot.ExtendingArm.Move(direction);
	}

	protected boolean isFinished()
	{

		// isFinished keeps checking to see if this command is ...well... finished.
		// Once a true bool is returned, this check ends and the command quits.
		// If false is returned, the command continues.

		// going down
		if (direction == 1.0) {
			return TalonLeft.getSelectedSensorPosition() <= positionNew;

		// going up
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
