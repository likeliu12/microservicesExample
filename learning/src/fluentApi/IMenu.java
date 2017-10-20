package fluentApi;

public interface IMenu {
    public IMenu order(int index);
    public IMenu eat();
    public IMenu pay();
    public IItem get(int index);
}
