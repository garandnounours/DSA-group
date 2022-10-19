import java.util.Scanner;
import java.util.Vector;
import java.util.ArrayList;
public class CreatingPlaylist {
    class Node{
        //this creates a node
        String song;
        Node previous;
        Node next;
        public Node(String song){
            this.song=song;
        }
    }
    static Node head;
    Node tail=null;
    public void addSong(String song){
        Node newNode=new Node(song);
        if (head==null){
            head=tail=newNode;
            head.previous=null;
            tail.next=null;
        }
        else {
            tail.next=newNode;
            newNode.previous=tail;
            tail=newNode;
            tail.next=null;
            System.out.println("\t Song(s) successfully added!!!");

        }
    }
    public void deleteSongs(String song){
        if (head==null){
            if (head.next==null){
                head=null;
            }
            else{
                Node temp;
                temp=this.head;
                while(temp.next.next==null){
                    temp=temp.next;
                }
                tail=temp.next;
                tail.next=null;
            }
        }
    }
    public void playSongs(){
        Node currentSong=head;
        if (head==null){
            System.out.println("There are no songs left in the playlist");
        }
        while(currentSong!=null){
            System.out.println(currentSong.song + " ");
            currentSong=currentSong.next;
        }
    }
    public static void main(String[] args) {
        CreatingPlaylist playlist=new CreatingPlaylist();
        int resp1;
        ArrayList<String> tracks=new ArrayList<>();
        char response;
        String track,plName;
        Scanner sc=new Scanner(System.in);
        System.out.println("\n \t Do you want to create a playlist: Y/N");
        System.out.print("> : ");
        response=sc.next().charAt(0);
        if (response=='y'){
            System.out.println("Enter playlist NAme: ");
            System.out.print("> : ");
            plName=sc.next();
            System.out.println("*** playlist "+ plName+ " successfully created!!! ***");
            while(true) {

                System.out.println("----------------------------------------------------------------------------------");
                        System.out.println(" \t 1 .Add song");
                System.out.println(" \t 2 .Delete song");
                System.out.println(" \t 3 .Play song ");
                System.out.println(" \t 4 .Search song");
                System.out.println(" \t 5 .Quit ");
                System.out.println("----------------------------------------------------------------------------------");
                        System.out.print("> : ");
                resp1=sc.nextInt();
                if (resp1==1){
                    Scanner input=new Scanner (System.in);
                    int numberOfSongs;
                    System.out.println(" How many songs do you want to add?");
                            numberOfSongs=input.nextInt();
                    System.out.print("> : ");
                    for (int i=0;i<numberOfSongs;i++) {
                        String responseNames;
                        System.out.println(" -----Enter the song name-----"+(i+1));
                                responseNames = sc.next();
                        System.out.print("> : ");
                        playlist.addSong(responseNames);
                    }
                }
                else if(resp1==2){
                    Scanner input=new Scanner (System.in);
                    int numberOfSongs;
                    System.out.println(" How many songs do you want to delete?");
                            numberOfSongs=input.nextInt();
                    System.out.print("> : ");
                    for (int i=0;i<numberOfSongs;i++) {
                        String responseNames;
                        System.out.println(" -----Enter the song name-----"+(i+1));
                                responseNames = sc.next();
                        System.out.print("> : ");
                        playlist.deleteSongs(responseNames);
                    }
                }
                else if(resp1==3){
                    playlist.playSongs();
                }
                else if(resp1==5){
                    break;
                }
                else if (resp1==4){
                    System.out.println("Enter song Name: ");
                    String songName=sc.next();
                    playlist.searchSong(songName);
                    System.out.println(" Do you want to play it ?(y/n) ");
                    char input=sc.next().charAt(0);
                    System.out.println(" > : ");
                    if(input=='y'){
                        System.out.println("Your song"+ songName +" is playing");
                    }
                    else {
                        return;
                    }
                }
                else {
                    System.out.println(" I did not understand your response!!!");

                }
            }
        }
        else if(response=='n'){
            System.out.println("Good bye!!");
            System.exit(0);
        }
        else{
            System.out.println(" !!! I did not understand your response. Please respond with (y/n) !!! \t");
            main(args);
        }
    }
    public void searchSong(String songName){
        int index=1;
        Node currentSong=head;
        boolean isFound=false;
        if (head==null){
            System.out.println(" There are no songs left in the playlist ");
        }
        while(currentSong!=null){
            if(currentSong.song.equals(songName)){
                isFound=true;
                break;
            }
            currentSong=currentSong.next;
            index++;
        }
        if (isFound){System.out.println("-----Song "+ songName+"is  found-----");}

 else{
                System.out.println("Song not found into you playlist!!!!");

            }
        }
    }
