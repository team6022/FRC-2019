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
	public static final int UpperArm = 4;
	public static final int LowerArmLeft = 5;
	public static final int LowerArmRight = 6;



	// VelcroPistons Channels
	public static final int VelcroPistonsForwardChannel = 0;
	public static final int VelcroPistonsReverseChannel = 1;
	public static final int BackLiftPistonsForwardChannel = 2;
	public static final int BackLiftPistonsReverseChannel = 3;
	public static final int FrontLiftPistonsForwardChannel = 4;
	public static final int FrontLiftPistonsReverseChannel = 5;

}
