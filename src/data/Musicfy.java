/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author Usuario
 */
public class Musicfy implements Serializable {

    private List<Song> songs;
    private List<Album> albums;
    private List<Artist> artists;
    private List<PlayList> playlists;

    public Musicfy(List<Song> songs, List<Album> albums, List<Artist> artists, List<PlayList> playlists) {
        this.songs = songs;
        this.albums = albums;
        this.artists = artists;
        this.playlists = playlists;
    }

    public Musicfy() {

    }

    //FUNCIONES ADD: 
    public void addAlbum(Album album) {
        if (this.albums == null || this.albums.isEmpty()) {
            this.albums = new ArrayList<>();
        }

        this.albums.add(album);
    }

    public void addSong(Song song) {
        if (this.songs == null || this.songs.isEmpty()) {
            this.songs = new ArrayList<>();
        }

        this.songs.add(song);
    }

    public void addArtist(Artist artista) {
        if (this.artists == null || this.artists.isEmpty()) {
            this.artists = new ArrayList<>();
        }

        this.artists.add(artista);
    }

    public void addPlaylist(PlayList playlist) {
        if (this.playlists == null || this.playlists.isEmpty()) {
            this.playlists = new ArrayList<>();
        }

        this.playlists.add(playlist);
    }

    public void addSongToPlayList(PlayList aAddSongTo, Song s) {
        if (this.playlists == null || this.playlists.isEmpty()) {
            return;
        }
        aAddSongTo.getCanciones().add(s);

    }

    //FUNCIONES REMOVE: 
    public void removeAlbum(Album album) {
        if (this.albums == null || this.albums.isEmpty()) {
            return;
        }
        this.albums.remove(album);
    }

    public void removeSong(Song song) {
        if (this.songs == null || this.songs.isEmpty()) {
            return;
        }

        this.songs.remove(song);
    }

    public void removeArtist(Artist artista) {
        if (this.artists == null || this.artists.isEmpty()) {
            return;
        }
        this.artists.remove(artista);
    }

    public void removePlaylist(PlayList playlist) {
        if (this.playlists == null || this.playlists.isEmpty()) {
            return;
        }
        this.playlists.remove(playlist);
    }

    public void removeSongFromPlayList(PlayList playlist, Song song) {
        if (this.playlists == null || this.playlists.isEmpty()) {
            return;
        }

        playlist.getCanciones().remove(song);

    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public List<PlayList> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<PlayList> playlists) {
        this.playlists = playlists;
    }

    public List<String> getArtistsInColumns() {
        if (this.artists == null || this.artists.isEmpty()) {
            return null;
        }
        List<String> artistasColumnados = new ArrayList<>();
        for (Artist artista : this.artists) {
            artistasColumnados.add(artista.toColumnedString());
        }

        return artistasColumnados;
    }

    public List<String> getAlbumesInHMTL() {
        if (this.albums == null || this.albums.isEmpty()) {
            return null;
        }

        List<String> albumesHTML = new ArrayList<>();
        for (Album album : this.albums) {
            albumesHTML.add(album.toHTMLString());
        }

        return albumesHTML;
    }

    public List<Artist> generateRandomArtists() {

        List<Artist> amigo = new ArrayList<>();
        setArtists(amigo);
        Random r = new Random();
        List<Artist> generarRandom = new ArrayList<>();
        String[] nombres = {"MIRIAM MAKEBA", "ABIGAIL", "AC", "ACDC", "ADANOWSKY",
            "ADELE", "ALEXANDRA STAN", "ALICIA KEYS", "ALONDRA BENTLEY", "ALUNAGEORGE",
            "AMAIA MONTERO", "AMARAL", "AMPARANOIA", "AMPARO SANCHEZ", "AMY WINEHOUSE",
            "ANA BELEN", "ANA MENA", "ANASTACIA", "ANNI B SWEET", "ANTONIO MACHIN", "AVICII",
            "AVRIL LAVIGNE", "AZEALIA BANKS", "BEA MILLER", "BEATRIZ LUENGO", "BEBE", "BELANOVA",
            "BELEN ARJONA", "BELINDA", "BEYONCE & JAY Z", "BEYONCE", "BLACK EYES PEAS", "BRITNEY SPEARS",
            "BUIKA", "CAMILA CABELLO", "CANDY DULFER", "CARLOS JEAN", "CELINE DION", "CHAMBAO", "CHAVELA VARGAS",
            "CHERYL COLE", "CHRISTINA AGUILERA", "CHRISTINA ROSENVINGE", "CHUCK BERRY", "COCOROSIE", "CORINNE BAILEY RAE",
            "COTI", "CRISTINA LLORENTE", "DAVID GUETTA", "DAVINIA GLORIA", "DEMI LOVATO", "DESTINY'S CHILD",
            "DIANA NAVARRO", "DIANA ROSS", "DON OMAR", "DOVER", "DUA LIPA", "ED SHEERAN", "EDURNE",
            "EFECTO MARIPOSA", "EFECTO PASILLO", "EFECTO MARIPOSA", "EL SUEÑO DE MORFEO", "EMELI SANDE",
            "EMINEM", "ENYA", "ESPERANZA FERNÁNDEZ", "FITO & FITIPALDIS", "GEORGINA", "GIOVANCA", "GLORIA ESTEFAN",
            "GLORIA GAYNOR", "GWEN STEFANI", "HANNA", "HILARY DUFF", "ICONA POP", "IDA CORR", "INDIA MARTINEZ", "INNA",
            "JAMELIA", "JAMES BLUNT", "JANET JACKSON", "JARABE DE PALO", "JENNIFER LOPEZ", "JERRY LEE LEWIS",
            "JESS GLYNNE", "JESSIE J", "JOHN COLTRANE", "JOSS STONE", "JUAN LUIS GUERRA", "JUAN MAGAN",
            "JULIETA VENEGAS", "JUSTIN TIMBERLAKE", "KATIE THIROUX", "KATY PERRY", "KATY PERRY", "KATY PERRY",
            "KESHA", "KELLY ROWLAND", "KEPA JUNKERA", "KESHA", "KEVIN ROLDAN", "KRISTINA RENEE",
            "KYLIE MINOGUE", "KYLIE MINOGUE", "LA NEGRA", "LA OREJA DE VAN GOGH", "LA QUINTA ESTACIÓN",
            "LADY GAGA", "LANA DEL REY", "LAS NINAS", "LAURA WRIGHT", "LEANN RIMES", "LENA", "LEONA LEWIS",
            "LEONARD COHEN", "LILY ALLEN", "LOREEN", "LORI MEYERS", "LUCRECIA", "LUZ CASAL", "MACY GRAY",
            "MADONNA", "MADREDEUS", "MAFUMI UENO", "MAGO DE OZ", "MAJOR LAZER", "MALA RODRIGUEZ",
            "MALDITA NEREA", "MALUMA", "MALÚ", "MARCELA MORELO", "MARIA DE MEDEIROS", "MARIAH CAREY",
            "MARIZA", "MARLANGO", "MAROON 5", "MARTA BOTIA", "MARTA SANCHEZ", "MARY J BLIGE",
            "MEGHAN TRAINOR", "MELENDI", "MERCHE", "MICHELLE WILLIAMS", "MIGUEL BOSE", "MILEY CYRUS",
            "MORCHEEBA", "MORCHEEBA", "NAJWA NIMRI", "NAJWA", "NAJWAJEAN", "NATALIA LAFOURCADE",
            "NAUGHTY BOY", "NELLY FURTADO", "NENA DACONTE", "NENEH CHERRY", "NICKI MINAJ", "NIÑA PASTORI",
            "NO DOUBT", "NO DOUBT", "NORAH JONES", "OCEANA", "PASTORA SOLER", "PASTORA", "PASTORA SOLER",
            "PATRICK DOYLE", "PAULINA RUBIO", "PINK", "PITBULL", "RED HOT CHILI PEPPERS", "RIHANNA", "RITA ORA",
            "ROLLING STONES", "ROSANA", "ROSARIO", "ROZALEN", "RUSSIAN RED", "RUSSIAN RED", "SADE", "SEINABO SEY",
            "SELENA GOMEZ", "SELENA GOMEZ", "SHAKIRA", "SHAKIRA", "SHAKIRA", "SIA", "SOFIA REYES",
            "SORAYA ARNELAS", "SORAYA ARNELAS", "STACEY KENT", "SUGABABES", "SUGAR BROWN", "SWEET CALIFORNIA",
            "T.A.T.U.", "TAYLOR SWIFT", "TEXAS", "THALIA", "THE CHEMICAL BROTHERS", "THE ROLLING STONES",
            "THE VERONICAS", "TIMBALAND", "TINA TURNER", "TINASHE", "TONI BRAXTON", "TRACY CHAPMAN",
            "TRAIN", "ULITA KNAUS", "ULITA KNAUS", "VAN MORRISON", "VANESA MARTIN", "VANESSA CARLTON",
            "VEGA", "VEGA", "VEGA", "VICENTE AMIGO", "VIOLADORES DEL VERSO", "WITHIN TEMPTATION",
            "ZAHARA", "ZAHARA", "ZARA LARSSON", "ZEETEAH MASSIAH", "ZENIT"};
        List<String> nombres_ar = new ArrayList<>();
        for (String l : nombres) {
            nombres_ar.add(l);
        }
        String[] biografias = {"BIOGRAFIA_1", "BIOGRAFIA_2", "BIOGRAFIA_3",
            "BIOGRAFIA_4", "BIOGRAFIA_5", "BIOGRAFIA_6", "BIOGRAFIA_7", "BIOGRAFIA_8",
            "BIOGRAFIA_9", "BIOGRAFIA_10", "BIOGRAFIA_11", "BIOGRAFIA_12"};

        String[] albumes = {"MAMA AFRICA", "CUATRO ES", "DC", "CALIFORNICATION", "HIGHWAY TO HELL",
            "AMADOR", "19", "21", "25", "HELLO", "ALESTA", "GIRL ON FIRE", "HERE", "AS I AM",
            "ASHFIELD AVENUE", "BODY MUSIC", "2", "SI DIOS QUIERE YO TAMBIEN", "HACIA LO SALVAJE",
            "NOCTURNAL SOLAR SESSIONS", "NOCTURNAL", "EL CORO DE MI GENTE", "TUCSON HABANA",
            "BACK TO BLACK", "FRANK", "LIONESS HIDDEN TREASURES", "VIDA", "INDEX", "EVOLUTION",
            "IT'S A MAN'S WORLD", "PIECES OF A DREAM", "RESURRECTION", "ULTIMATE COLLECTION",
            "ITS A MANS WORLD", "OH, MONSTERS!", "START RESTARY UNDO", "30 GRANDES EXITOS",
            "THE DAYS NIGHTS", "AVRIL LAVIGNE DELUXE EDITION", "FANTASEA", "AURORA",
            "BELA Y SUS MOSKITAS MUERTAS", "CUERPO Y ALMA", "CAMBIO DE PIEL", "UN POKITO DE ROCANROL",
            "SUEÑO ELECTRO I", "INFINITO", "CARPE DIEM", "EVERYTHING IS LOVE", "BEYONCE", "I AM SASHA FIERCE",
            "LEMONADE", "BDAY", "I AM... WORLD TOUR", "FULL ALBUM ELEPHUNK", "MONKEY BUSINESS", "THE BEGINNING",
            "CAN YOU HANDLE MINE", "CONTROVERSY", "GLORY", "BRITNEY JEAN", "THE UNRELEASED", "PARA MI",
            "VIVIR SIN MIEDO", "CAMILA", "TOGETHER", "COMBUSTION SOUNDTRACK", "LOVED ME BACK TO LIFE",
            "TAKING CHANCES", "CON OTRO AIRE", "NUEVO CICLO", "POKITO A POKO", "CUPAIMA", "MESSY LITTLE RAINDROPS",
            "LIBERATION", "UN HOMBRE RUBIO", "CHUCK", "GREY OCEANS", "CORINNE BAILEY RAE", "GATOS Y PALOMAS",
            "PERMISO PARA SER YO", "7", "LISTEN", "TE REGALO", "CONFIDENT", "DEMI", "#1'S", "24 ROSAS",
            "I LOVE YOU", "KING OF KINGS", "I KA KENÉ", "FOLLOW THE CITY LIGHT", "DUA LIPA (DELUXE EDITION)",
            "DIVIDE (DELUXE EDITION)", "EDURNE", "40 04", "BARRIO LAS BANDERAS", "COMPLEJIDAD", "BUSCAMOS SONRISAS",
            "NOS VEMOS EN EL CAMINO", "OUR VERSION OF EVENTS", "KING MATHERS", "DARK SKY ISLAND", "MI VOZ EN TU PALABRA",
            "HUYENDO CONMIGO DE MI", "DILEMA", "ENSAYO Y ERROR", "RARA", "CASI", "WHILE I M AWAKE", "NO LLORES",
            "THE ANTHOLOGY", "THE SWEET ESCAPE", "THIS IS WHAT THE TRUTH FEELS LIKE", "PURA HANNA", "MOST WANTED",
            "THIS IS... ICONA POP", "CORR VALUES", "OTRAS VERDADES", "TE CUENTO UN SECRETO", "INNA [COMPLETE EDITION]",
            "NIRVANA (DELUXE EDITION)", "BODY AND THE SUN", "WALK WITH ME", "BACK TO BEDLAM", "UNBREAKABLE",
            "50 PALOS", "THIS IS R&B (THE FEATURINGS)", "COMO AMA UNA MUJER", "BRAVE", "LOVE",
            "LAST MAN STANDING ADVANCE", "I CRY WHEN I LAUGH", "SWEET TALKER (DELUXE VERSION)",
            "WHO YOU ARE (PLATINUM EDITION)", "ALIVE", "AFRO BLUE IMPRESSIONS 1963", "INTRODUCING JOSS STONE",
            "A SON DE GUERRA", "ELECTROLATINO EL ORIGEN", "ALGO SUCEDE", "LOS MOMENTOS", "MAN OF THE WOODS",
            "THE BOOK OF LOVE", "JUSTIFIED", "THE 2020 EXPERIENCE", "INTRODUCING KATIE THIROUX", "TEENAGE DREAM",
            "WITNESS", "PRISM", "WARRIOR", "TALK A GOOD GAME", "GALIZA", "RAINBOW", "THE BEGINNING", "TAMING TIGERS",
            "X", "KISS ME ONCE", "LA QUE NUNCA", "EL PLANETA IMAGINARIO", "GUAPA", "COMETAS POR EL CIELO",
            "FLORES DE ALQUILER", "EL MUNDO SE EQUIVOCA", "APPLAUSE", "BORN THIS WAY", "JOANNE", "ARTPOP",
            "LUST FOR LIFE", "MP3 PLAY", "BORN TO DIE", "HONEYMOON", "SAVIA NEGRA", "THE LAST ROSE", "FAMILY",
            "LENA", "I AM", "OLD IDEAS", "ALRIGHT STILL", "HEAL", "IMPRONTA", "MIRA LAS LUCES", "QUE CORRA EL AIRE",
            "VIDA TOXICA", "BIG", "COVERED", "THE SELLOUT", "RUBY", "STRIPPED", "THE WAY",
            "CONFESSIONS ON A DANCE FLOOR", "MDNA", "STICKY AND SWEET MILAN", "REBEL HEART",
            "ICONIC UNAPOLOGETIC BITCH", "ESSENCIA", "FALUAS DO TEJO", "TEA FOR TWO", "CELTIC LAND",
            "PEACE IS THE MISSION", "BRUJA", "DIRTY BAILARINA", "MALAMARISMO", "BAILARINA", "DESAFIO",
            "DUAL", "GUERRA FRÍA", "SI", "F.A.M.E.", "CAOS", "ESPINAS & PETALOS", "A LITTLE MORE BLUE",
            "THE EMANCIPATION OF MIMI", "MUNDO", "EL PORVENIR", "LIFE IN THE TREEHOUSE", "V", "OVEREXPOSED",
            "MARTAMENTE", "MISS SANCHEZ", "GROWING PAINS", "THANK YOU", "QUITATE LAS GAFAS", "ACORDES DE MI DIARIO",
            "DE OTRA MANERA", "NECESITO LIBERTAD", "QUIERO CONTARTE", "UN MUNDO DE COLORES", "CAL Y ARENA",
            "JOURNEY TO FREEDOM", "PAPITO", "BANGERZ", "YOUNGER NOW", "CAN T BE TAMED", "BLAZE AWAY", "HEAD UP HIGH",
            "DONDE RUGEN LOS VOLCANES", "RAT RACE", "WALKABOUT", "EL ULTIMO PRIMATE", "BONZO", "HASTA LA RAIZ",
            "MUSAS", "HOTEL CABANA", "LOOSE", "THE RIDE", "UNDERCOVER", "UNA MOSCA EN EL CRISTAL",
            "HE PERDIDO LOS ZAPATOS", "SOLO MUERDO POR TI", "BROKEN POLITICS", "BLANK PROJECT", "LEGACY",
            "JOYAS PRESTADAS", "BAJO TUS ALAS", "PUSH AND SHOVE", "EVERYTHING IN TIME", "NOT TOO LATE",
            "MY HOUSE", "LA CALMA", "LA VIDA MODERNA", "CONOCEME", "BRAVE", "ANANDA", "BRAVA!", "DESEO",
            "I M NOT DEAD", "CLIMATE CHANGE", "DALE", "GLOBALIZATION", "THE GETAWAY", "ANTI", "GOOD GIRL GONE BAD",
            "LOUD", "WORK", "PHOENIX", "A BIGGER BANG", "8 LUNAS", "EN LA MEMORIA DE LA PIEL",
            "¡¡BUENOS DÍAS, MUNDO!!", "MAGIA", "LAS VOCES DE ROSARIO", "CONTIGO ME VOY", "CUANDO EL RIO SUENA...",
            "CON DERECHO A...", "QUIEN ME HA VISTO...", "AGENT COOPER", "FUERTEVENTURA", "I LOVE YOUR GLASSES",
            "KARAOKE", "SOLDIER OF LOVE", "PRETEND", "REVIVAL", "STARS DANCE", "EL DORADO", "HIPS DONT LIE",
            "SALE EL SOL", "THIS IS ACTING", "LOUDER!", "DREAMER", "CORAZON DE FUEGO", "BREAKFAST ON THE MORNING TRAM",
            "TALLER IN MORE WAYS", "POOR LAZARUS", "3", "HEAD FOR THE STARS", "ORIGEN", "DANGEROUS AND MOVING",
            "1989", "REPUTATION", "RED", "RED BOOK", "VALIENTE (2018)", "DON'T THINK", "BLUE & LONESOME",
            "THE SECRET LIFE OF", "PUSH THE BUTTON", "BORN IN THE ECHOES", "KEEP IT REAL", "PRESENTS SHOCK",
            "LOVE SONGS", "JOYRIDE", "SEX & CIGARETTES", "GREATEST HITS", "CALIFORNIA", "SO LOST LIKE PEACE",
            "ITS THE CITY", "KEEP ME SINGING", "ROLL WITH THE PUNCHES", "VERSATILE", "AGUA", "CRONICA DE UN BAILE",
            "CUESTION DE PIEL", "MUNAY", "TRAMPAS", "TODAS LAS MUJERES QUE HABITAN EN MI", "LIBERMAN", "CIRCULAR",
            "LA REINA PEZ", "LA CUENTA ATRAS", "MEMORIA DE LOS SENTIDOS", "VIVIR PARA CONTARLO", "STAND MY GROUND",
            "ASTRONAUTA", "LA PAREJA TÓXICA", "SO GOOD", "JUICE", "TORRE DE BABEL"};

        List<String> nombres_al = new ArrayList<>();
        for (String l : albumes) {
            nombres_al.add(l);
        }
        String nombre;
        String[] todos;

        int aleatorios = r.nextInt(nombres_ar.size());
        try {
            for (int i = 0; i < aleatorios; i++) {
                Artist adding = new Artist();
                int artistaco = r.nextInt(nombres_ar.size());
                List<String> lista_albums = new ArrayList<>();
                adding.setNombre(nombres_ar.get(artistaco));
                nombre = adding.getNombre();
                nombres_ar.remove(nombre);
                todos = adding.getNombre().split(" ");
                adding.setBiografia(biografias[r.nextInt(biografias.length)]);
                adding.setInstagram("@" + adding.getNombre().replace(" ", "_") + "2019");
                adding.setFacebook("@" + adding.getNombre().replace(" ", "_") + "2019");
                adding.setTwitter("@" + adding.getNombre().replace(" ", "_") + "2019");
                adding.setWikipedia("https://es.wikipedia.org/wiki/" + adding.getNombre().toLowerCase().replace(" ", "_"));
                int randomAlbums = 1 + r.nextInt(5);
                for (int j = 0; j < randomAlbums; j++) {
                    int aBorrar = r.nextInt(nombres_al.size());
                    lista_albums.add(nombres_al.get(aBorrar));
                    nombres_al.remove(aBorrar);
                }
                adding.setAlbumes(lista_albums);
                generarRandom.add(adding);

            }
        } catch (Exception ec) {
            System.out.println("");
        }

        setArtists(generarRandom);
        return generarRandom;

    }

    public List<Album> generateRandomAlbums(List<Artist> aleatorios) {
        Random r = new Random();
        List<String> albumes = new ArrayList<>();
        List<Album> generarRandom = new ArrayList<>();
        List<Song> randomSongs = new ArrayList<>();
        String[] canciones = {"Cant Hold Us", "Wrecking Ball", "La La La", "Pour It Up", "Beautiful Liar",
            "We Cant Stop", "Don't You Worry Child", "Love The Way You Lie", "Aquellos ojos verdes", "212",
            "Liquorice", "runnin", "Seventeen", "Dime", "Sunrise", "Can't remember to forget you",
            "Woman's World", "Fight For This Love", "Fight For This Love", "chocar", "Who's That Chick",
            "I knew you were waiting", "Live It Up", "Is Anybody Out There", "Roar", "Xota da guía",
            "Perfect Combination", "Telephone", "para ti seria", "Diamonds", "Gangnam Style", "Cry baby cry",
            "Shady Love", "Feel This Moment", "Bara_Bara_Bere_Bere", "Te Voy A Esperar", "Drive By",
            "What a Wonderful World", "On The Floor Ft Pitbull", "In The Wee Small Hours Of The Morning",
            "Mood Indigo", "Glad To Be Unhappy", "I Get Along Without You Very Well", "Deep In A Dream",
            "I See Your Face Before Me", "Can't We Be Friends", "When Your Lover Has Gone",
            "What Is This Thing Called Love", "Last Night When We Were Young", "I'll Be Around",
            "Ill Wind", "It Never Entered My Mind", "Dancing On The Ceiling", "I'll Never Be The Same",
            "This Love Of Mine", "The Rooster Song", "My Happiness", "As Time Goes By", "Hey La Bas",
            "Love Me", "Don't You Hear Me Calling You", "It's You I Love", "Valley Of Tears", "Where Did You Stay",
            "Baby Please", "Thinking Of You", "You Know I Miss You", "You Make Me Feel So Young",
            "It Happened In Monterey", "You're Getting To Be A Habit With Me", "You Brought A New Kind Of Love To Me",
            "Too Marvelous For Words", "Old Devil Moon", "Pennies From Heaven", "Love Is Here To Stay",
            "I've Got You Under My Skin", "I Thought About You", "We'll Be Together Again", "Makin' Whoopee",
            "Swingin' Down The Lane", "Anything Goes", "How About You", "Bird On A Wire", "Story Of Isaac",
            "A Bunch Of Lonesome Heroes", "The Partisan", "Seems So Long Ago, Nancy", "The Old Revolution",
            "The Butcher", "You Know Who I Am", "Lady Midnight", "Tonight Will Be Fine", "Hells Bells",
            "Shoot to Thrill", "What do You do For Money Honey", "Given The Dog a Bone",
            "Let me Put my Love Into You", "Back in Black", "You Shook me All Night Long", "Have a Drink on Me",
            "Shake a Leg", "Rock And Roll Ain't Noise Pollution", "Me Siento Solo", "Lo Que Siempre Fué",
            "Amor Sin Fin", "Dime Cuando", "Basta Del Oscuro", "Saber Amar", "Un Sol Con Corazón",
            "J'aime Tes Genoux", "Asi Ya No Me Quiero", "You Are The One", "daydreams", "Rolling in the Deep",
            "Rumour Has It", "Turning Tables", "Don't You Remember", "Set Fire to the Rain", "He Won't Go",
            "Take It All", "I'll Be Waiting", "One and Only", "Lovesong", "Someone Like You",
            "I Found a Boy (Bonus Track)", "Turning Tables (Live Acoustic)", "Don't You Remember (Live Acoustic)",
            "Someone Like You (Live Acoustic)", "If It Hadn't Been For Love", "Hiding My Heart", "Hello",
            "Send My Love  (To Your New Lover)", "I Miss You", "When We Were Young", "Remedy",
            "Water Under The Bridge", "River Lea", "Love In The Dark", "Million Years Ago", "All I Ask",
            "Sweetest Devotion", "Step It Up", "Get What You Give", "We Wanna", "Alone", "Ecoute", "Balans",
            "Coco Banana", "I Did It Mama", "9 Lives", "La Fuega", "Boom Pow", "Motive", "Baby, It's Ok",
            "De Novo Adagio(Intro)", "Brand New Me", "When It's All Over", "Listen To Your Heart", "New Day",
            "Girl On Fire(Inferno Version)", "Fire We Make(Ft.Maxwell)", "Tears Always Win", "Not Even The King",
            "That's When I Knew", "Limitedless", "One Thing", "101", "Cuestión de Suerte", "Caminando",
            "Dónde estabas", "Tu mirada", "Sabes", "Noviembre", "Hasta siempre compañero", "Perdóname",
            "Una sola vez", "Entre tú y yo", "A tu lado", "Palabras", "Darte Mi Vida", "Fuiste Algo Importante",
            "Todo Corazón", "Cuando Canto", "Inevitable", "Im-Possible", "Yo a Ti Tambien", "Los Abrazos Rotos",
            "Contigo No Me Voy", "Azul Eléctrico", "Madrid-Ipanema", "Hacia Lo Salvaje", "Antártida",
            "Si Las Calles Pudieran Hablar", "Esperando Un Resplandor", "Robin Hood", "Riazor", "Montaña Rusa",
            "Olvido", "Cuando Suba La Marea", "Como Un Martillo En La Pared", "Hoy Es El Principio Del Final",
            "Van Como Locos", "Llevame Muy Lejos", "Unas Veces Se Gana y Otras Se Pierde", "Nocturnal",
            "La Ciudad Maldita", "Lo Que Nos Mantiene Unidos", "500 Vidas", "Cazador", "Nadie Nos Recordara",
            "La Niebla", "Laberintos", "Chatarra", "En El Tiempo Equivocado", "Noche de Cuchillos", "Hacer Dinero",
            "El Coro De Mi Gente", "En La Noche", "Somos Viento", "Dolor, Dolor", "Que Te Den", "Mar Estrecho",
            "El Destino", "La Fiesta", "Iluminando", "La Semana", "Ella Baila Bembe", "Caravane",
            "You Know What I Mean", "Buen Rollito", "Rehab", "You Know I'm No Good", "Me And Mr Jones",
            "Just Friends", "Back To Black", "Love Is A Losing Game", "Tears Dry On Their Own", "Wake Up Alone",
            "Some Unholy War", "He Can Only Hold Her", "Addicted", "Our Day Will Come", "Between The Cheats",
            "Tears Dry", "Will You Still Love Me Tomorrow", "Like Smoke", "Valerie", "The Girl From Ipanema",
            "Half Time", "Wake Up Alone", "Best Friends, Right", "Body and Soul", "A Song For You",
            "Isla que habitas en mi", "Alga quisiera ser", "Cuentos para dormir", "Mujer Valiente",
            "¿Quién manda ahí afuera?", "Cuando te encontré", "Esta vida es un regalo", "Tú, yo",
            "Soy lo que soy", "Everest", "Vida", "Ramble On", "Best Of You", "Sweet Child O' Mine",
            "You Can't Always Get What You Want", "One", "Back In Black", "Dream On", "Use Somebody",
            "You Give Love A Bad Name", "Wonderwall", "I'm Outta Love", "Not That Kind", "Cowboys & Kisses",
            "Made For Lovin' You", "Paid My Dues", "One Day In Your Life", "Why'd You Lie To Me",
            "You'll Never Be Alone", "Left Outside Alone", "Sick and Tired", "Welcome To My Truth",
            "Heavy On My Heart", "Everything Burns", "I Belong To You (Il ritmo della passione)",
            "Pieces Of A Dream", "In Your Eyes", "Megamix", "At Home", "Getting Older", "Catastrophe Of Love",
            "Ridiculous Games 2060", "Locked In Verses", "Missing A Stranger", "The Closer", "Mute My Mind",
            "Monters", "Remember Today", "Good Bye Child", "Someone Else", "Gone If I Close My Eyes",
            "Hole In My Room", "The Days", "The Nights", "The Days (Henrik B Remix)",
            "Alguien (Spanish Adaptation Of Use Somebody)", "Como Tí No Hay 2", "Ley De Newton",
            "Platos Rotos", "Lengua", "Chicas De Revista", "Fábulas Del Blah Blah Blah", "Love",
            "Flor De Loto", "He Prometido", "Sin Mirar Atrás", "Hallelujah", "Caprichosa", "Delito",
            "Postureo", "Amarrao", "El Tan Tan", "La Mala", "Sabor, Sabor", "Aquí Te Espero", "El Amante",
            "Ojos de Mandela", "Si Un Día Vuelves", "No Me Dejes Caer", "Cadillac", "Más Que Suerte",
            "Te Echo De Menos", "Despedida", "Aquí Te Espero", "Respirar", "Borrones", "La cuenta",
            "Que llueva", "Bala perdida", "Tan lejos tan cerca", "Animales hambrientos", "Chica precavida",
            "Ganamos", "Una canción", "Más que a mi vida", "Todo lo que deseaba", "ABC", "Adiós", "Me Pintaré",
            "Sabrás", "CompraPaga", "Mi Guapo", "K.I.E.R.E.M.E", "Der Pelo", "Qué Carajo", "Tilón", "Yo Fumo",
            "Pretty Hurts", "Haunted", "Drunk In Love", "Blow", "No Angel", "Partition", "Jealous", "Rocket",
            "Mine", "XO", "Flawless", "Superpower", "Heaven", "Blue", "Alien", "Work Bitch", "Perfume",
            "It Should Be Easy", "Tik Tik Boom", "Body Ache", "Til It's Gone", "Passenger", "Chillin' With You",
            "Don't Cry", "Brightest Morning Star", "Hold On Tight", "Now That I Found You", "Perfume"};

        List<String> nombres_so = new ArrayList<>();

        for (String l : canciones) {
            nombres_so.add(l);
        }
        for (Artist a : aleatorios) {
            for (String s : a.getAlbumes()) {
                albumes.add(s);
            }
        }
        List<String> albumsartistas = new ArrayList<>();

        for (Artist a : aleatorios) {
            for (String al : a.getAlbumes()) {
                albumsartistas.add(al);
            }
        }

        for (String comprobar : albumes) {
            List<String> interpretes = new ArrayList<>();

            try {
                for (Artist tiene : aleatorios) {
                    if (tiene.getAlbumes().contains(comprobar)) {
                        interpretes.add(tiene.getNombre());

                    }
                }

                String cantantes = interpretes.toString().replace(",", ";").replace("[", "").replace("]", "");
                Album adding = new Album();
                int a = r.nextInt(100);

                if (a < 50) {
                    adding.setTipo("sencillo");
                    adding.setTitulo(comprobar);
                    adding.setDuracion(1 + r.nextInt(4) + " mins," + r.nextInt(59) + " seg");
                    adding.setNumero_canciones(1);
                    adding.setAgno(1980 + r.nextInt(40));
                    adding.setInterpretes(interpretes);
                    Song song;
                    String can = "";

                    List<Song> cans = new ArrayList<>();
                    String cancion = adding.getTitulo() + "\t" + cantantes
                            + "\t" + adding.getAgno() + "\t" + adding.getDuracion();
                    song = Song.instanceFromStringFromSingle(cancion);
                    cans.add(song);
                    adding.setCanciones(cans);
                    randomSongs.add(song);
                    //System.out.println(adding.getTitulo() + adding.getInterpretes());

                }

                if (a >= 50) {
                    adding.setTipo("álbum");
                    adding.setTitulo(comprobar);
                    adding.setDuracion(5 + r.nextInt(4) + " mins," + r.nextInt(59) + " seg");
                    adding.setNumero_canciones(2 + r.nextInt(10));
                    adding.setAgno(1980 + r.nextInt(40));
                    adding.setInterpretes(interpretes);
                    //System.out.println("Interpretes de " + adding.getTitulo() + ": " + interpretes);
                    List<Song> cans = new ArrayList<>();
                    String can = "";
                    Song song;
                    for (String l : interpretes) {
                        can = can + ";" + l;
                    }
                    for (int j = 0; j < adding.getNumero_canciones(); j++) {
                        String name = nombres_so.get(r.nextInt(nombres_so.size()));
                        String cancion = name + "\t" + cantantes
                                + "\t" + adding.getAgno() + "\t" + adding.getDuracion();
                        song = Song.instanceFromStringFromAlbum(cancion);
                        cans.add(song);
                        randomSongs.add(song);
                    }
                    adding.setCanciones(cans);
                }
                generarRandom.add(adding);
            } catch (Exception ec) {
                System.out.println("");
            }
        }

        setArtists(aleatorios);
        setSongs(randomSongs);
        setAlbums(generarRandom);
        return generarRandom;

    }

    public List<PlayList> generateRandomPlaylists() {

        Random r = new Random();
        List<PlayList> randomPlaylists = new ArrayList<>();
        List<Song> listadecanciones = getSongs();
        for (Song s : listadecanciones) {
            //System.out.println(s);
        }
        List<String> nombres_pl = new ArrayList<>();
        String[] nombres = {"Sólo éxitos", "¡Fiesta y Bailoteo!", "Latino Caliente",
            "Descubrimientos semanales", "El top 50 de España", "Todo Éxitos", "Baila y perrea",
            "Canciones a punto de petarlo", "Novedades Sony", "Dance Music 2019", "Alternative Rules",
            "GYM Motivation", "Lo mejor del 2019", "Daily Mix 1", "Daily Mix 2", "Daily Mix 3", "Daily Mix 4",
            "Éxitos para trabajar", "Tu top de canciones 2019", "Tu top de canciones 2018", "Tu top de canciones 2017",
            "Tu top de canciones 2016", "Rock Español", "Pop Clásico", "Pop con Ñ", "Trapeo", "Éxitos España",
            "Verano Forever", "Latin Pop VIP", "Radar Latino", "Duetos", "Despierta y sonríe", "Fuego",
            "Trap Latino", "Latin Cardio"};

        for (String l : nombres) {
            nombres_pl.add(l);
        }
        int numeroplaylists = r.nextInt(10);
        for (int j = 0; j < numeroplaylists; j++) {
            PlayList adding = new PlayList();
            List<Song> canciones = new ArrayList<>();
            String nombre = nombres_pl.get(r.nextInt(nombres_pl.size()));
            nombres_pl.remove(nombre);
            adding.setNombre(nombre);
            int randomSongs = r.nextInt(20);
            for (int z = 0; z < randomSongs; z++) {
                Song song;
                int cansion = (int) Math.floor(Math.random() * (20 - 1 + 1) + 1);
                song = listadecanciones.get(cansion - 1);
                listadecanciones.remove(song);
                canciones.add(song);
            }
            adding.setCanciones(canciones);
            randomPlaylists.add(adding);

        }

        setPlaylists(randomPlaylists);
        return randomPlaylists;
    }

}
