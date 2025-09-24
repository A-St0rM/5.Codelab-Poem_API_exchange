package app.DAO;


import app.entities.Poem;

public class PoemDAO extends GenericDAO<Poem, Integer> {

    public PoemDAO() {
        super(Poem.class);
    }

}
