package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;



public class ExtendingArmMovePosition extends Command
{

	static TalonSRX TalonLeft = new TalonSRX(RobotMap.ExtendingArmLeft);

	Integer position = 0;

	public ExtendingArmMovePosition(Integer _position)
	{
		requires(Robot.ExtendingArm);
		position = _position;
	}

	protected void initialize()
	{
	}

	protected void execute()
	{
		Robot.ExtendingArm.MovePosition(position);
	}

	protected boolean isFinished()
	{
		// stop running command only when the left talon is equal to the position that was set
		return TalonLeft.getSelectedSensorPosition() == position;
	}

	protected void end()
	{
	}

	protected void interrupted()
	{
	}

}
