package Domain;

import java.util.UUID;

public class Outil {

    private Float m_diametre;
    private  String m_nom;
    private UUID id;
    public Outil( final String p_nom, Float p_diametre) {
        m_diametre = p_diametre;
        m_nom = p_nom;
        id = UUID.randomUUID();

    }
}
