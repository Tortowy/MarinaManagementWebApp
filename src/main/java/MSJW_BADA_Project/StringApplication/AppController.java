package MSJW_BADA_Project.StringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

@Configuration
@Controller
public class AppController implements WebMvcConfigurer {

    private PocztyDAO pocztyDao;
    private AdresyDAO adresyDao;
    private StanowiskaDAO stanowiskaDao;
    private PracownicyDAO pracownicyDao;
    private KlienciDAO klienciDao;
    private MarinyDAO marinyDao;



    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("/index");
        registry.addViewController("/").setViewName("/index");
        registry.addViewController("/main").setViewName("/main");
        registry.addViewController("/login").setViewName("/login");

        registry.addViewController("/owner/main_owner").setViewName("/owner/main_owner");
        registry.addViewController("/employee/main_employee").setViewName("/employee/main_employee");

        registry.addViewController("/owner/post/owner_adding_post").setViewName("/owner/post/owner_adding_post");
        registry.addViewController("/owner/post/post_management").setViewName("/owner/post/post_management");

        registry.addViewController("/owner/adres/adres_management").setViewName("/owner/adres/adres_management");
        registry.addViewController("/owner/adres/owner_adding_adres").setViewName("/owner/adres/owner_adding_adres");

        registry.addViewController("/owner/position/position_management").setViewName("/owner/position/position_management");
        registry.addViewController("/owner/position/owner_adding_position").setViewName("/owner/position/owner_adding_position");

        registry.addViewController("/owner/employee/employee_management").setViewName("/owner/employee/employee_management");
        registry.addViewController("/owner/employee/owner_adding_employee").setViewName("/owner/employee/owner_adding_employee");

        registry.addViewController("/owner/client/client_management").setViewName("/owner/client/client_management");
        registry.addViewController("/owner/client/owner_adding_client").setViewName("/owner/client/owner_adding_client");

        registry.addViewController("/employee/client/client_management").setViewName("/employee/client/client_management");
        registry.addViewController("/employee/client/employee_adding_client").setViewName("/employee/client/employee_adding_client");

        registry.addViewController("/employee/adres/adres_management").setViewName("/employee/adres/adres_management");
        registry.addViewController("/employee/adres/employee_adding_adres").setViewName("/employee/adres/employee_adding_adres");


    }


    @Controller
    public class DashboardController{
        @RequestMapping("/main")
        public String defaultAfterLogin
                (HttpServletRequest request) {
            if (request.isUserInRole("OWNER")){
                return "redirect:/owner/main_owner";
            }
            else if(request.isUserInRole("EMPLOYEE")){
                return "redirect:/employee/main_employee";
            }
            else{
                return "redirect:/index";
            }
        }

        @RequestMapping("/addressManagement")
        public String addressManagementError
                (HttpServletRequest request) {
            if (request.isUserInRole("OWNER")){
                return "redirect:/owner/adres/adres_management";
            }
            else if(request.isUserInRole("EMPLOYEE")){
                return "redirect:/employee/adres/adres_management";
            }
            else{
                return "redirect:/index";
            }
        }

        @RequestMapping("/clientManagement")
        public String clientManagementError
                (HttpServletRequest request) {
            if (request.isUserInRole("OWNER")){
                return "redirect:/owner/client/client_management";
            }
            else if(request.isUserInRole("EMPLOYEE")){
                return "redirect:/employee/client/client_management";
            }
            else{
                return "redirect:/index";
            }
        }



    }






    @RequestMapping(value={"/owner/post/post_management"})
    public String showPostPage(Model model) {

        List<Poczty> pocztyList = pocztyDao.list();
        model.addAttribute("pocztyList",pocztyList);
        return "/owner/post/post_management";
    }

    @RequestMapping(value={"/owner/post/owner_adding_post"})
    public String showAddingPostPage(Model model) {
        Poczty poczty = new Poczty();
        model.addAttribute("poczty",poczty);
        return "/owner/post/owner_adding_post";
    }

    @RequestMapping(value={"/savePost"},method = RequestMethod.POST)
    public String savePost(@ModelAttribute("poczty") Poczty poczty) {

        pocztyDao.save(poczty);

        return "redirect:/owner/post/post_management";
    }


    @RequestMapping("/owner/post/edit_post_form/{nrPoczty}")
    public ModelAndView showPostEditForm(@PathVariable(name = "nrPoczty") int nrPoczty){
        ModelAndView mav = new ModelAndView("/owner/post/edit_post_form");
        Poczty poczty = pocztyDao.get(nrPoczty);
        mav.addObject("poczty",poczty);

        return mav;
    }

    @RequestMapping(value = "/updatePost", method = RequestMethod.POST)
    public String updatePost(@ModelAttribute("poczty") Poczty poczty) {

        pocztyDao.update(poczty);

        return "redirect:/owner/post/post_management";
    }

    @RequestMapping(value= "/owner/post/delete_post/{nrPoczty}")
    public String deletePost(@PathVariable(name = "nrPoczty") int nrPoczty , Model model){
        try{
            pocztyDao.delete(nrPoczty);
        }catch (Exception e){
            model.addAttribute("nrPoczty",nrPoczty);
            return "errors/PostDeleteError";
        }


        return "redirect:/owner/post/post_management";
    }


    @RequestMapping(value={"/main_employee"})
    public String showUserPage(Model model) {
        return "employee/main_employee";
    }


    ///////////
    ///////////
    // ADRESY//
    ///////////
    ///////////


    @RequestMapping(value={"/owner/adres/adres_management"})
    public String showAdresPage(Model model) {

        List<Adresy> adresyList = adresyDao.list();
        model.addAttribute("adresyList",adresyList);
        return "/owner/adres/adres_management";
    }


    @RequestMapping(value={"/owner/adres/owner_adding_adres"})
    public String showAddingAdresPage(Model model) {
        Adresy adresy = new Adresy();
        model.addAttribute("adresy",adresy);

        List<Poczty> pocztyList = pocztyDao.list();
        model.addAttribute("pocztyList",pocztyList);

        return "/owner/adres/owner_adding_adres";
    }

    @RequestMapping(value={"/saveAdres"},method = RequestMethod.POST)
    public String saveAdres(@ModelAttribute("adresy") Adresy adresy) {
        adresyDao.save(adresy);
        return "redirect:/owner/adres/adres_management";
    }

    @RequestMapping("/owner/adres/edit_adres_form/{nrAdresu}")
    public ModelAndView showAdresEditForm(@PathVariable(name = "nrAdresu") int nrAdresu, Model model){
        ModelAndView mav = new ModelAndView("/owner/adres/edit_adres_form");
        Adresy adresy = adresyDao.get(nrAdresu);
        mav.addObject("adresy",adresy);

        List<Poczty> pocztyList = pocztyDao.list();
        model.addAttribute("pocztyList",pocztyList);

        return mav;
    }

    @RequestMapping(value = "/updateAdres", method = RequestMethod.POST)
    public String updateAdres(@ModelAttribute("adresy") Adresy adresy) {

        adresyDao.update(adresy);

        return "redirect:/owner/adres/adres_management";
    }


    @RequestMapping(value= "/owner/adres/delete_adres/{nrAdresu}")
    public String deleteAdres(@PathVariable(name = "nrAdresu") int nrAdresu, Model model){


        try{
            adresyDao.delete(nrAdresu);
        }catch (Exception e){
            model.addAttribute("nrAdresu",nrAdresu);
            return "errors/AddressDeleteError";
        }


        return "redirect:/owner/adres/adres_management";
    }



    ///////////////
    ///////////////
    // STANOWISKA//
    ///////////////
    ///////////////




    @RequestMapping(value={"/owner/position/position_management"})
    public String showPositionPage(Model model) {

        List<Stanowiska> stanowiskaList = stanowiskaDao.list();
        model.addAttribute("stanowiskaList",stanowiskaList);
        return "/owner/position/position_management";
    }

    @RequestMapping(value={"/owner/position/owner_adding_position"})
    public String showAddingPositionPage(Model model) {
        Stanowiska stanowiska = new Stanowiska();
        model.addAttribute("stanowiska",stanowiska);
        return "/owner/position/owner_adding_position";
    }

    @RequestMapping(value={"/savePosition"},method = RequestMethod.POST)
    public String savePosition(@ModelAttribute("stanowiska") Stanowiska stanowiska) {
        stanowiskaDao.save(stanowiska);
        return "redirect:/owner/position/position_management";
    }

    @RequestMapping("/owner/position/edit_position_form/{nrStanowiska}")
    public ModelAndView showPositionEditForm(@PathVariable(name = "nrStanowiska") int nrStanowiska){
        ModelAndView mav = new ModelAndView("/owner/position/edit_position_form");
        Stanowiska stanowiska = stanowiskaDao.get(nrStanowiska);
        mav.addObject("stanowiska",stanowiska);

        return mav;
    }

    @RequestMapping(value = "/updatePosition", method = RequestMethod.POST)
    public String updatePosition(@ModelAttribute("stanowiska") Stanowiska stanowiska) {

        stanowiskaDao.update(stanowiska);

        return "redirect:/owner/position/position_management";
    }


    @RequestMapping(value= "/owner/position/delete_position/{nrStanowiska}")
    public String deletePosition(@PathVariable(name = "nrStanowiska") int nrStanowiska, Model model){



        try{
            stanowiskaDao.delete(nrStanowiska);
        }catch (Exception e){
            model.addAttribute("nrStanowiska",nrStanowiska);
            return "errors/PositionDeleteError";
        }

        return "redirect:/owner/position/position_management";
    }


    ///////////////
    ///////////////
    // PRACOWNICY//
    ///////////////
    ///////////////



    @RequestMapping(value={"/owner/employee/employee_management"})
    public String showEmployeePage(Model model) {

        List<Pracownicy> pracownicyList = pracownicyDao.list();
        model.addAttribute("pracownicyList",pracownicyList);
        return "/owner/employee/employee_management";
    }

    @RequestMapping(value={"/owner/employee/owner_adding_employee"})
    public String showAddingEmployeePage(Model model) {
        Pracownicy pracownicy = new Pracownicy();
        model.addAttribute("pracownicy",pracownicy);
        List<Adresy> adresyList = adresyDao.list();
        model.addAttribute("adresyList",adresyList);

        List<Stanowiska> stanowiskaList= stanowiskaDao.list();
        model.addAttribute("stanowiskaList",stanowiskaList);

        List<Mariny> marinyList = marinyDao.list();
        model.addAttribute("marinyList",marinyList);

        return "/owner/employee/owner_adding_employee";
    }

    @RequestMapping(value={"/saveEmployee"},method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("pracownicy") Pracownicy pracownicy) {

        pracownicyDao.save(pracownicy);
        return "redirect:/owner/employee/employee_management";
    }

    @RequestMapping("/owner/employee/edit_employee_form/{nrPracownika}")
    public ModelAndView showEmployeeEditForm(@PathVariable(name = "nrPracownika") int nrPracownika, Model model){
        ModelAndView mav = new ModelAndView("/owner/employee/edit_employee_form");
        Pracownicy pracownicy = pracownicyDao.get(nrPracownika);

        List<Adresy> adresyList = adresyDao.list();
        model.addAttribute("adresyList",adresyList);

        List<Stanowiska> stanowiskaList= stanowiskaDao.list();
        model.addAttribute("stanowiskaList",stanowiskaList);

        List<Mariny> marinyList = marinyDao.list();
        model.addAttribute("marinyList",marinyList);


        mav.addObject("pracownicy",pracownicy);

        return mav;
    }

    @RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
    public String updateEmployee(@ModelAttribute("pracownicy") Pracownicy pracownicy) {

        pracownicyDao.update(pracownicy);

        return "redirect:/owner/employee/employee_management";
    }


    @RequestMapping(value= "/owner/employee/delete_employee/{nrPracownika}")
    public String deleteEmployee(@PathVariable(name = "nrPracownika") int nrPracownika, Model model){


        try{
            pracownicyDao.delete(nrPracownika);
        }catch (Exception e){
            model.addAttribute("nrPracownika",nrPracownika);
            return "errors/EmployeeDeleteError";
        }

        return "redirect:/owner/employee/employee_management";
    }




    ///////////////
    ///////////////
    // KLIENCI   //
    ///////////////
    ///////////////


    @RequestMapping(value={"/owner/client/client_management"})
    public String showClientPage(Model model) {

        List<Klienci> klienciList = klienciDao.list();
        model.addAttribute("klienciList",klienciList);
        return "/owner/client/client_management";
    }

    @RequestMapping(value={"/owner/client/owner_adding_client"})
    public String showAddingClientPage(Model model) {
        Klienci klienci = new Klienci();
        model.addAttribute("klienci",klienci);

        List<Adresy> adresyList = adresyDao.list();
        model.addAttribute("adresyList",adresyList);

        // Tutaj skoczylem ostatnio jak pisalem cos w controllerze

        List<Mariny> marinyList = marinyDao.list();
        model.addAttribute("marinyList",marinyList);

        return "/owner/client/owner_adding_client";
    }

    @RequestMapping(value={"/saveClient"},method = RequestMethod.POST)
    public String saveClient(@ModelAttribute("klienci") Klienci klienci) {

        klienciDao.save(klienci);
        return "redirect:/owner/client/client_management";
    }

    @RequestMapping("/owner/client/edit_client_form/{nrKlienta}")
    public ModelAndView showClientEditForm(@PathVariable(name = "nrKlienta") int nrKlienta, Model model){
        ModelAndView mav = new ModelAndView("/owner/client/edit_client_form");
        Klienci klienci = klienciDao.get(nrKlienta);
        mav.addObject("klienci",klienci);

        List<Adresy> adresyList = adresyDao.list();
        model.addAttribute("adresyList",adresyList);

        // Tutaj skoczylem ostatnio jak pisalem cos w controllerze

        List<Mariny> marinyList = marinyDao.list();
        model.addAttribute("marinyList",marinyList);


        return mav;
    }

    @RequestMapping(value = "/updateClient", method = RequestMethod.POST)
    public String updateClient(@ModelAttribute("klienci") Klienci klienci) {

        klienciDao.update(klienci);

        return "redirect:/owner/client/client_management";
    }


    @RequestMapping(value= "/owner/client/delete_client/{nrKlienta}")
    public String deleteClient(@PathVariable(name = "nrKlienta") int nrKlienta, Model model){

        try{
            klienciDao.delete(nrKlienta);
        }catch (Exception e){
            model.addAttribute("nrKlienta",nrKlienta);
            return "errors/ClientDeleteError";
        }

        return "redirect:/owner/client/client_management";
    }



    /////////////////////////////////////////////
    /////////////////////////////////////////////
    // ADRESY ZARZADZANE PRZEZ PRACOWNIKA   ////
    /////////////////////////////////////////////
    /////////////////////////////////////////////




    @RequestMapping(value={"/employee/adres/adres_management"})
    public String showAdresPageForEmployee(Model model) {

        List<Adresy> adresyList = adresyDao.getAdresyOfClients();
        model.addAttribute("adresyList",adresyList);
        return "/employee/adres/adres_management";
    }



    @RequestMapping(value={"/employee/adres/employee_adding_adres"})
    public String showAddingAdresPageByEmployee(Model model) {
        Adresy adresy = new Adresy();
        model.addAttribute("adresy",adresy);

        List<Poczty> pocztyList = pocztyDao.list();
        model.addAttribute("pocztyList",pocztyList);

        return "/employee/adres/employee_adding_adres";
    }

    @RequestMapping(value={"/saveAdresEmployee"},method = RequestMethod.POST)
    public String saveAdresEmployee(@ModelAttribute("adresy") Adresy adresy) {
        adresyDao.save(adresy);
        return "redirect:/employee/adres/adres_management";
    }

    @RequestMapping("/employee/adres/edit_adres_form/{nrAdresu}")
    public ModelAndView showAdresEditFormForEmployee(@PathVariable(name = "nrAdresu") int nrAdresu, Model model){
        ModelAndView mav = new ModelAndView("/employee/adres/edit_adres_form");
        Adresy adresy = adresyDao.get(nrAdresu);
        mav.addObject("adresy",adresy);

        List<Poczty> pocztyList = pocztyDao.list();
        model.addAttribute("pocztyList",pocztyList);

        return mav;
    }

    @RequestMapping(value = "/updateAdresEmployee", method = RequestMethod.POST)
    public String updateAdresEmployee(@ModelAttribute("adresy") Adresy adresy) {

        adresyDao.update(adresy);

        return "redirect:/employee/adres/adres_management";
    }


    @RequestMapping(value= "/employee/adres/delete_adres/{nrAdresu}")
    public String deleteAdresEmployee(@PathVariable(name = "nrAdresu") int nrAdresu, Model model){
        try{
            adresyDao.delete(nrAdresu);
        }catch (Exception e){
            model.addAttribute("nrAdresu",nrAdresu);
            return "errors/AddressDeleteError";
        }


        return "redirect:/employee/adres/adres_management";
    }



    //////////////////////////////
    //////////////////////////////
    // EMPLOYEE KLIENCI   ///////////////
    //////////////////////////////
    //////////////////////////////


    @RequestMapping(value={"/employee/client/client_management"})
    public String showClientPageEmployee(Model model) {

        List<Klienci> klienciList = klienciDao.list();
        model.addAttribute("klienciList",klienciList);
        return "/employee/client/client_management";
    }

    @RequestMapping(value={"/employee/client/employee_adding_client"})
    public String showAddingClientPageEmployee(Model model) {
        Klienci klienci = new Klienci();
        model.addAttribute("klienci",klienci);

        List<Adresy> adresyList = adresyDao.list();
        model.addAttribute("adresyList",adresyList);

        List<Mariny> marinyList = marinyDao.list();
        model.addAttribute("marinyList",marinyList);

        return "/employee/client/employee_adding_client";
    }

    @RequestMapping(value={"/saveClientEmployee"},method = RequestMethod.POST)
    public String saveClientEmployee(@ModelAttribute("klienci") Klienci klienci) {

        klienciDao.save(klienci);
        return "redirect:/employee/client/client_management";
    }

    @RequestMapping("/employee/client/edit_client_form/{nrKlienta}")
    public ModelAndView showClientEditFormEmployee(@PathVariable(name = "nrKlienta") int nrKlienta, Model model){
        ModelAndView mav = new ModelAndView("/employee/client/edit_client_form");
        Klienci klienci = klienciDao.get(nrKlienta);
        mav.addObject("klienci",klienci);

        List<Adresy> adresyList = adresyDao.list();
        model.addAttribute("adresyList",adresyList);

        // Tutaj skoczylem ostatnio jak pisalem cos w controllerze

        List<Mariny> marinyList = marinyDao.list();
        model.addAttribute("marinyList",marinyList);


        return mav;
    }

    @RequestMapping(value = "/updateClientEmployee", method = RequestMethod.POST)
    public String updateClientEmployee(@ModelAttribute("klienci") Klienci klienci) {

        klienciDao.update(klienci);

        return "redirect:/employee/client/client_management";
    }


    @RequestMapping(value= "/employee/client/delete_client/{nrKlienta}")
    public String deleteClientEmployee(@PathVariable(name = "nrKlienta") int nrKlienta, Model model){
        try{
            klienciDao.delete(nrKlienta);
        }catch (Exception e){
            model.addAttribute("nrKlienta",nrKlienta);
            return "errors/ClientDeleteError";
        }

        return "redirect:/employee/client/client_management";
    }





    /////////////////////////////////////////////
    /////////////////////////////////////////////
    // Dodawanie DAO                         ////
    /////////////////////////////////////////////
    /////////////////////////////////////////////






    @Autowired
    public void setKlienciDao(KlienciDAO klienciDao) {
        this.klienciDao = klienciDao;
    }

    @Autowired
    public void setPocztyDao(PocztyDAO pocztyDao) {
        this.pocztyDao = pocztyDao;
    }

    @Autowired
    public void setAdresyDao(AdresyDAO adresyDao) {
        this.adresyDao = adresyDao;
    }

    @Autowired
    public void setStanowiskaDao(StanowiskaDAO stanowiskaDao) {
        this.stanowiskaDao = stanowiskaDao;
    }

    @Autowired
    public void setPracownicyDao(PracownicyDAO pracownicyDao) {
        this.pracownicyDao = pracownicyDao;
    }

    @Autowired
    public void setMarinyDao(MarinyDAO marinyDao){
        this.marinyDao = marinyDao;
    }

}

