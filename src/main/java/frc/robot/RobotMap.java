package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around
 */
public class RobotMap
{

	// VictorSP Channels
	public static final int SP1Channel = 0;
	public static final int SP2Channel = 1;
	public static final int SP3Channel = 2;
	public static final int SP4Channel = 3;
	public static final int LowerArm = 4;
	public static final int UpperArm = 5;


	// VelcroPistons Channels
	public static final int VelcroPistonsLeftForwardChannel = 0;
	public static final int VelcroPistonsLeftReverseChannel = 1;
	public static final int VelcroPistonsRightForwardChannel = 2;
	public static final int VelcroPistonsRightReverseChannel = 3;

}
