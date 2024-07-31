package Model;

public class Blog_Coffee {
	private int id;
	private String title;
	private String description;
	private String imgurl;

	public Blog_Coffee() {
	}

	public Blog_Coffee(String title, String description, String imgurl) {
		super();
		this.title = title;
		this.description = description;
		this.imgurl = imgurl;
	}
	
	public Blog_Coffee(int id, String title, String description, String img_url) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.imgurl = img_url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
}
