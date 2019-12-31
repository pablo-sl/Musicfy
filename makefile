JFLAGS = -g
JC = javac
.SUFFIXES: .class .java
	$(JC) $(JFLAGS) $*java

PabloSanchezLosada_70921072C.jar: Controller.class Album.class Artist.class ComparadorAlbumes.class ComparadorCanciones.class ComparadorDeAgnoAlbum.class ComparadorDeAgnoSong.class ComparadorDeTituloAlbum.class ComparadorDeTituloSong.class Constants.class Model.class Musicfy.class PlayList.class Song.class View.class MusicfyPabloSL.class
	jar cmfv manifest PabloSanchezLosada_70921072C.jar Controller.class Album.class Artist.class ComparadorAlbumes.class ComparadorCanciones.class ComparadorDeAgnoAlbum.class ComparadorDeAgnoSong.class ComparadorDeTituloAlbum.class ComparadorDeTituloSong.class Constants.class Model.class Musicfy.class PlayList.class Song.class View.class MusicfyPabloSL.class


CLASSES = \
	Controller.java \
	Album.java \
	Artist.java \
	ComparadorAlbumes.java \
	ComparadorCanciones.java \
	ComparadorDeAgnoAlbum.java \
	ComparadorDeAgnoSong.java \
	ComparadorDeTituloAlbum.java \
	ComparadorDeTituloSong.java \
	Constants.java \
	Model.java \
	Musicfy.java \
	PlayList.java \
	Song.java \
	View.java \
	MusicfyPabloSL.java \
default:classes

classes: $(CLASSES:.java=.class)
clean:
	$(RM) *.class
