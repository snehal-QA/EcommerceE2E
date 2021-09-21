package utilities;

public class BaseManager {

	private WebDriverManager webdrivermanager;
	private ConfigFileReader config;
	private Generators generators;

	public BaseManager(WebDriverManager webdrivermanager, ConfigFileReader config, Generators generators) {

		this.webdrivermanager = webdrivermanager;
		this.config = config;
		this.generators = generators;
	}

	public WebDriverManager getWebdrivermanager() {
		return webdrivermanager;
	}

	public void setWebdrivermanager(WebDriverManager webdrivermanager) {
		this.webdrivermanager = webdrivermanager;
	}

	public ConfigFileReader getConfig() {
		return config;
	}

	public void setConfig(ConfigFileReader config) {
		this.config = config;
	}

	public Generators getGenerators() {
		return generators;
	}

	public void setGenerators(Generators generators) {
		this.generators = generators;
	}

}
