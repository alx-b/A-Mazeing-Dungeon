package com.company;

public class SpecialRoom extends Room {
    private Store store = null;
    private DragonBoss dragon = null;
    private Item item = null;
    private QuestItem questItem = null;

    public SpecialRoom(String name, int row, int col){
        super(name, row, col);
        if (name.equals("Store")){
            this.store = new Store();
        }else if (name.equals("Dragon")){
            this.dragon = new DragonBoss("Dino, the maze-keeper", 700, 50, 700);
        }else if (name.equals("Dragon Tooth")){
            this.questItem = new QuestItem("Dragon Tooth");
        }
    }

    public void displayRoom(Hero hero) throws InterruptedException {
        if (this.store != null){
            this.store.buyItemsInStore(hero);
        } else if (this.dragon != null){
            this.dragon.quest(hero);
        } else if (this.item != null){
            hero.addItemToBackpack(this.item);
        } else if (this.questItem != null){
            System.out.printf("You have found: %s\n", this.questItem.getName());
            hero.addQuestItemToQuestBag(this.questItem);
        }
    }
}
