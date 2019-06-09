package pageObjects;

import decorator.elements.Button;
import decorator.elements.PageElement;
import decorator.elements.TextInput;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class TrainingListPage extends AbstractPage {

   private static final Logger LOG = Logger.getLogger(TrainingListPage.class);

   @FindBy(xpath = "//*[@class='filter-field__arrow-icon' and @ng-click='openSkillsDropDown()']")
   private Button expandAllSkillsArrow;

   @FindBy(xpath =  "//*[@class='filter-field__arrow-icon arrow-icon-rotate' and @ng-click='openSkillsDropDown()']")
   private Button collapseAllSkillsArrow;

   @FindBy(xpath = "//input[@ng-model='searchTrainingBySkills']")
   private TextInput skillsSearchInput;

   @FindBy(xpath = "//label[contains(@ng-class,'Skill')]")
   private List<WebElement> skillsSearchResultsList;

   public TrainingListPage expandSkillsModalWindow(){
      waitForElementToBeVisible(expandAllSkillsArrow);
      expandAllSkillsArrow.click();
      LOG.info("Expand 'Skills' modal window");
      return this;
   }

   public TrainingListPage collapseSkillsModalWindow(){
      collapseAllSkillsArrow.click();
      LOG.info("Collapse 'Skills' modal window");
      return this;
   }

   public boolean isSkillsModalWindowExpanded(){
      return collapseAllSkillsArrow.isDisplayed();
   }

   public TrainingListPage performSearchInSkills(String searhTerm){
      skillsSearchInput.sendKeys(searhTerm);
      return this;
   }

   public TrainingListPage clearSkillsInput(){
      skillsSearchInput.clear();
      return this;
   }

   public List<WebElement> getSkillsSearchResultsElements(){
      System.out.println(skillsSearchResultsList.size());
      return skillsSearchResultsList;
   }

   public boolean isSkillsSearchResultsPresent(){
      return !skillsSearchResultsList.isEmpty();
   }
}
