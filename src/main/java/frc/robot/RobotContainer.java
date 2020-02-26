/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.FeedForward;
import frc.robot.commands.FeederRaise;
import frc.robot.commands.spinDeploy;
import frc.robot.commands.spinFunction;
import frc.robot.commands.spinRetract;
import frc.robot.commands.FeedBackward;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Sensors;
import frc.robot.subsystems.colourWheel;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Drivetrain;
import frc.robot.commands.FeederLower;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer
{
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  //subsystems
    public static final Drivetrain m_DriveTrain = new Drivetrain();
    public static final Feeder m_Feeder = new Feeder();
    public static final colourWheel m_wheel = new colourWheel();
    public static Sensors m_sensors = new Sensors();

  //OI
    public static final Joystick m_joystick = new Joystick(Constants.JS_JOYSTICK_1_PORT);

    private static final JoystickButton button_feedforward = new JoystickButton(m_joystick, Constants.CB_FEEDER_FEEDFORWARD_BUTTON);
    private static final JoystickButton button_feedbackward = new JoystickButton(m_joystick, Constants.CB_FEEDER_FEEDBACKWARD_BUTTON);

    private static final JoystickButton button_feedraise = new JoystickButton(m_joystick, Constants.CB_FEEDER_FEEDRAISE_BUTTON);
    private static final JoystickButton button_feedlower = new JoystickButton(m_joystick, Constants.CB_FEEDER_FEEDLOWER_BUTTON);

    private static final JoystickButton button_wheelSpinner = new JoystickButton(m_joystick, Constants.CW_SPINNER_BUTTON);
    private static final JoystickButton button_wheelDeploy = new JoystickButton(m_joystick, Constants.CW_DEPLOY_BUTTON);
    private static final JoystickButton button_wheelRetract = new JoystickButton(m_joystick, Constants.CW_RETRACT_BUTTON);
  
    /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer()
  {
    // Configure the button bindings
    configureButtonBindings();

    m_DriveTrain.setDefaultCommand(new ArcadeDrive());
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings()
  {

    button_feedforward.whileHeld(new FeedForward());
    button_feedbackward.whileHeld(new FeedBackward());

    button_feedraise.whenPressed(new FeederRaise());
    button_feedlower.whenPressed(new FeederLower());

    button_wheelSpinner.whenPressed(new spinFunction(m_wheel));
    button_wheelDeploy.whenPressed(new spinDeploy(m_wheel));
    button_wheelRetract.whenPressed(new spinRetract(m_wheel));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand()
  {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
