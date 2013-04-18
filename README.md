Antpass
=======

Simple Ant extention for Java Swing password input.

By default, ant input is echoed in clear text if you just do:

    <input message="Please enter SSH password:" addproperty="ssh.password" />

Ant provides a stdio-based password input but it doesn't work in Eclipse. 
This extension offers a Java swing dialog for passord input. To use it:

1. Get the jar of this little project.
2. Add it to the `path of the Ant Runtime Configuration in eclipse
3. Use:

    <input message="Please enter SSH password:" addproperty="ssh.password" >
      <handler classname="com.akolov.antpass.PasswordInputHandler" />
    </input>
    
That's it.
