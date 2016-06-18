<p style="text-align: center;"><strong>EMF PERSISTENCE</strong></p>
<p style="text-align: justify;">This project contains ecliplse project folders. The project org.emf.persistence is an epsilon plugin project and as such, it should work with a current version of epsilon without requiring any modifications to the users development environment. The project org.proto.persistence requires google protocol buffers to be installled on the users machine.</p>
<p style="text-align: justify;">&nbsp;</p>
<p style="text-align: center;"><strong>Projects</strong></p>
<p style="text-align: left;"><strong>org.emf.persistence:</strong></p>
<p style="text-align: justify;">In this project, a library model is created and persisted using emfs default persistence mechanisms (Binary and XMI). The persistence code is within the 'main' package. The Binary persistence code can be found in the BinaryPersistence.java file. The XMI persistence code can be found in the XMIPersistence.java file. By default both methods will save and load from to a location relative to the location of the eclipse project on disk. Command line arguments can be passed to both&nbsp;BinaryPersistence.java&nbsp;XMIPersistence.java in order to specify a save location, e.g C:/Test/output.xmi .</p>
<p style="text-align: left;">&nbsp;</p>
<p style="text-align: justify;">&nbsp;</p>
