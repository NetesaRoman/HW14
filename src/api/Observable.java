package api;

    public interface Observable {

        public void notifyPersonel();

        public void registerPersonel(Observer o);

        public void removePersonel(Observer o);

}
