
package org.sync.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sync.Util.UtilDownload;
import org.sync.daoimpl.ExportDataDao;
import org.sync.model.AllChannelDetails;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import au.com.bytecode.opencsv.CSVReader;


@Controller
public class DataExportControler {

	@Autowired
	ExportDataDao exportdata;
    @Value("${csvInMysql}")
    String csvInMysqlpath;
    
    @Value("${movedCSV}")
    String movedCSVPath;
    
    @Value("${csvfilename}")
    String csvfilename;
    
    @Value("${pdffilename}")
    String pdffilename;
    
	@RequestMapping(value="/exportData/{fromdate}/{todate}",method=RequestMethod.POST)
	public @ResponseBody Map<String,List<AllChannelDetails>>  singleproductDashboard(@PathVariable("fromdate") String fromdate, @PathVariable("todate") String todate) { 

		System.out.println("start date...."+fromdate+"...end date..."+todate);
		List<AllChannelDetails> list=exportdata.allChannels(fromdate,todate);
		//System.out.println("all chanel frm channel 1.."+list);
		Map<String,List<AllChannelDetails>> map=new HashMap<>();
		map.put("data",list);
		return map;
	}

	@RequestMapping(value="/exportchannels/{fromdate}/{todate}",method=RequestMethod.POST)
	public @ResponseBody Map<String,List<AllChannelDetails>> filterDataDisplay(@PathVariable("fromdate") String fromdate, @PathVariable("todate") String todate,
			@RequestParam("brand") String brand,@RequestParam("category") String category,@RequestParam("product") String product,
			@RequestParam("channels") String channel,@RequestParam("language") String language,@RequestParam("genre") String genre) { 





		System.out.println("start date...."+fromdate+"...end date..."+todate+"..channel name."+channel);
		System.out.println("productname=="+product+"..category name="+category+"..brand.."+brand);


		List<AllChannelDetails> list=exportdata.allDataExport(channel,fromdate,todate,brand,category,product,language,genre);
		//System.out.println("all chanel frm channel 1.."+list);
		Map<String,List<AllChannelDetails>> map=new HashMap<>();
		map.put("data",list);
		return map;
	}

	//...........................filter options........................

	/*	@RequestMapping(value="/fetchAllOptins/{fromdate}/{todate}",method=RequestMethod.POST)
	public @ResponseBody List<AllChannelDetails>  allfilteroption(@PathVariable("fromdate") String fromdate, @PathVariable("todate") String todate) { 

		System.out.println("start date...."+fromdate+"...end date..."+todate);
		List<AllChannelDetails> list=new ArrayList<AllChannelDetails>();
		list=exportdata.allFilterOption(fromdate,todate);
		//System.out.println(" after all filter option method");
		return list;
	}*/

	@RequestMapping(value="/fetchannel/{fromdate}/{todate}",method=RequestMethod.POST)
	public @ResponseBody List<AllChannelDetails>  filterChannel(@PathVariable("fromdate") String fromdate, @PathVariable("todate") String todate) { 

		System.out.println("start date...."+fromdate+"...end date..."+todate);
		List<AllChannelDetails> list=new ArrayList<AllChannelDetails>();
		list=exportdata.allFilterChanel(fromdate,todate);
		//System.out.println(" after all filter option method");
		return list;
	}
	@RequestMapping(value="/categoryFilter/{fromdate}/{todate}",method=RequestMethod.POST)
	public @ResponseBody List<AllChannelDetails>  allFilterCategory(@PathVariable("fromdate") String fromdate, @PathVariable("todate") String todate,
			@RequestParam("channel") String channel , @RequestParam("brand") String brand) { 

		System.out.println("start date...."+fromdate+"...end date..."+todate+"   category name"+channel);
		List<AllChannelDetails> list=new ArrayList<AllChannelDetails>();
		list=exportdata.allFilterCategory(fromdate,todate,channel,brand);
		//System.out.println(" after all filter option method");
		return list;
	}


	@RequestMapping(value="/productfilter/{fromdate}/{todate}",method=RequestMethod.POST)
	public @ResponseBody List<AllChannelDetails>  allFilterProduct(@PathVariable("fromdate") String fromdate, @PathVariable("todate") String todate,
			@RequestParam("channel") String channel,@RequestParam("brand") String brand,@RequestParam("category") String category){ 

		System.out.println("start date...."+fromdate+"...end date..."+todate);
		List<AllChannelDetails> list=new ArrayList<AllChannelDetails>();
		list=exportdata.allFilterProduct(fromdate,todate,brand,channel,category);
		//System.out.println(" after all filter option method");
		return list;
	}

	@RequestMapping(value="/languageGenre/{fromdate}/{todate}",method=RequestMethod.POST)
	public @ResponseBody List<AllChannelDetails>  allFilterLanguage(@PathVariable("fromdate") String fromdate, @PathVariable("todate") String todate,
			@RequestParam("channel") String channel,@RequestParam("brand") String brand,@RequestParam("category") String category,@RequestParam("product") String product){ 

		System.out.println("start date...."+fromdate+"...end date..."+todate);
		List<AllChannelDetails> list=new ArrayList<AllChannelDetails>();
		list=exportdata.allFilterLanguageGenre(fromdate,todate,brand,channel,category,product);
		//System.out.println(" after all filter option method");
		return list;
	}


	@RequestMapping(value="/GenreFiltre/{fromdate}/{todate}",method=RequestMethod.POST)
	public @ResponseBody List<AllChannelDetails>  allFilterGenre(@PathVariable("fromdate") String fromdate, @PathVariable("todate") String todate,
			@RequestParam("channel") String channel,@RequestParam("brand") String brand,@RequestParam("category") String category,@RequestParam("product") String product){ 

		System.out.println("start date...."+fromdate+"...end date..."+todate);
		List<AllChannelDetails> list=new ArrayList<AllChannelDetails>();
		list=exportdata.allFilterGenre(fromdate,todate,brand,channel,category,product);
		//System.out.println(" after all filter option method");
		return list;
	}


	//..............................filter option close..................


	//...................................datefilter start..........................................................	


	@RequestMapping(value="/startDateFilter/{startdate}",method=RequestMethod.POST)
	public @ResponseBody List<AllChannelDetails>  startDateFilter(@PathVariable("startdate") String startdate) { 

		System.out.println("start date...."+startdate);
		List<AllChannelDetails> list=new ArrayList<AllChannelDetails>();
		list=exportdata.startDateFilter(startdate);
		//System.out.println(" after all filter option method");
		return list;
	}

	@RequestMapping(value="/endDateFilter/{endDate}/{startdate}",method=RequestMethod.POST)
	public @ResponseBody List<AllChannelDetails>  endDateFilter(@PathVariable("startdate") String startdate,
			@PathVariable("endDate") String enddate) { 

		System.out.println("start date...."+startdate+"..end date.."+enddate);
		List<AllChannelDetails> list=new ArrayList<AllChannelDetails>();
		list=exportdata.endDateFilter(startdate,enddate);
		//System.out.println(" after all filter option method");
		return list;
	}

	@RequestMapping(value="/endDateCategoryFilter/{endDate}/{startdate}",method=RequestMethod.POST)
	public @ResponseBody List<AllChannelDetails>  endDateCategoryFilter(@PathVariable("startdate") String startdate,
			@PathVariable("endDate") String enddate) { 

		System.out.println("start date...."+startdate+"..end date.."+enddate);
		List<AllChannelDetails> list=new ArrayList<AllChannelDetails>();
		list=exportdata.endDateCategoryFilter(startdate,enddate);
		//System.out.println(" after all filter option method");
		return list;
	}
	@RequestMapping(value="/endDateProductFilter/{endDate}/{startdate}",method=RequestMethod.POST)
	public @ResponseBody List<AllChannelDetails> endDateProductFilter(@PathVariable("startdate") String startdate,
			@PathVariable("endDate") String enddate) { 

		System.out.println("start date...."+startdate+"..end date.."+enddate);
		List<AllChannelDetails> list=new ArrayList<AllChannelDetails>();
		list=exportdata.endDateProductFilter(startdate,enddate);
		//System.out.println(" after all filter option method");
		return list;
	}


	@RequestMapping(value="/endDateLanguageFilter/{endDate}/{startdate}",method=RequestMethod.POST)
	public @ResponseBody List<AllChannelDetails> endDateLanguageFilter(@PathVariable("startdate") String startdate,
			@PathVariable("endDate") String enddate) { 

		System.out.println("start date...."+startdate+"..end date.."+enddate);
		List<AllChannelDetails> list=new ArrayList<AllChannelDetails>();
		list=exportdata.endDateLanguageFilter(startdate,enddate);
		//System.out.println(" after all filter option method");
		return list;
	}
	@RequestMapping(value="/endDateGenreFilter/{endDate}/{startdate}",method=RequestMethod.POST)
	public @ResponseBody List<AllChannelDetails> endDateGenreFilter(@PathVariable("startdate") String startdate,
			@PathVariable("endDate") String enddate) { 

		System.out.println("start date...."+startdate+"..end date.."+enddate);
		List<AllChannelDetails> list=new ArrayList<AllChannelDetails>();
		list=exportdata.endDateGenreFilter(startdate,enddate);
		//System.out.println(" after all filter option method");
		return list;
	}




	@RequestMapping(value="/endDateBrandFilter/{endDate}/{startdate}",method=RequestMethod.POST)
	public @ResponseBody List<AllChannelDetails>  endDateBrandFilter(@PathVariable("startdate") String startdate,
			@PathVariable("endDate") String enddate) { 

		System.out.println("start date...."+startdate+"..end date.."+enddate);
		List<AllChannelDetails> list=new ArrayList<AllChannelDetails>();
		list=exportdata.endDateBrandFilter(startdate,enddate);
		//System.out.println(" after all filter option method");
		return list;
	}

	// ..............brand to product filter............................................................

	@RequestMapping(value="/channelChangeFilter/{fromdate}/{todate}",method=RequestMethod.POST)
	public @ResponseBody List<AllChannelDetails>  channelChange(@PathVariable("fromdate") String fromdate, @PathVariable("todate") String todate,
			@RequestParam("channel") String channel) { 

		System.out.println("start date...."+fromdate+"...end date..."+todate+".....channel name..."+channel);
		List<AllChannelDetails> list=new ArrayList<AllChannelDetails>();
		list=exportdata.allFilterOption(fromdate,todate,channel);
		//System.out.println(" after all filter option method");
		return list;
	}	



	

	// Final working file download.
	@SuppressWarnings("null")
	@RequestMapping(value="/allDataExport2/{fromdate}/{todate}",method=RequestMethod.GET) 
	public ResponseEntity<?> exportData(@PathVariable("fromdate") String fromdate, @PathVariable("todate") String todate,
	  @RequestParam("channel") String channel,@RequestParam("brand") String brand,@RequestParam("product") String product,
	  @RequestParam("category") String category,@RequestParam("language") String language,@RequestParam("genre") String genre,
	  @RequestParam("exportData") String exportData,HttpServletRequest request, HttpServletResponse response) {
        
		UtilDownload util =new UtilDownload();
		System.out.println("mysql file path " +csvInMysqlpath);
        System.out.println("moved file in tomcat  path  " +movedCSVPath);
		System.out.println("product=="+product+" ==category name=="+category+"==channel=="+channel+"==brand"+brand);

	
		
		String ActualFilename=exportdata.completeReportExport(fromdate,todate,product,category,brand,channel,genre,language);
		System.out.println("query finished suucesfully."+ActualFilename);
		//String download = "/home/ubuntu/apache-tomcat-9.0.4/webapps/productImages/shipingdetails.txt";
		Path temp;
		String filePath = movedCSVPath;
		String fileName = pdffilename;
      
		System.out.println("select option value."+exportData);
		csvfilename=("SyncReport"+ActualFilename+".csv").trim();
		pdffilename=("SyncReport"+ActualFilename+".pdf").trim();
		
		System.out.println(" return csv file name "+csvfilename);
		System.out.println(" return pdf file name "+pdffilename);
		//................................	csv file download condition ..............................................

	
		
		if(exportData.equals("csv"))
		{
			
			System.out.println("in csv file condition");

			try {
				temp = Files.move (Paths.get(csvInMysqlpath+csvfilename),
						Paths.get(movedCSVPath+csvfilename));
				System.out.println("temp=="+temp);
				if(temp != null) 
				{ 
					System.out.println("File renamed and moved successfully"); 
				} 
				else
				{ 
					System.out.println("Failed to move the file"); 
				}


			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("file moved exception found.");
				e1.printStackTrace();
			}



			try { 
			//	File pdffile = null;
				File csvFile = null;
				String csvfile=csvfilename;
				

				csvFile = new File(filePath + csvfile );
				InputStream inputStream = new FileInputStream(csvFile);
				response.setContentType("application/force-download");
				response.setHeader("Content-Disposition", "attachment; filename="+csvfile); 
				IOUtils.copy(inputStream, response.getOutputStream());
				response.flushBuffer();
				inputStream.close();
				System.out.println("file download complete..");
				util.delete(csvFile);
				return ResponseEntity.ok().body("");
			} catch (Exception e) { 
				System.out.println(e);
				e.printStackTrace(); 
				return ResponseEntity.ok().body("500");
			}


		}

		else if(exportData.equals("pdf"))
		{
			System.out.println("in pdf file condition");

			File deletePdf = new File(csvInMysqlpath+pdffilename);
			
			try {
				if(deletePdf.exists())
				{
					System.out.println("deletePdfFile before deleteMethod file  "+deletePdf);
				util.delete(deletePdf);	
				System.out.println("deletePdfFile before moved file  ");
				}
				System.out.println("csvfilename in pdf ** ="+csvfilename);
				temp = Files.move (Paths.get(csvInMysqlpath+csvfilename),
						Paths.get(movedCSVPath+csvfilename));
				System.out.println("temp in pdf=="+temp);
				if(temp != null) 
				{ 
					System.out.println("File renamed in pdf file and moved successfully"); 
				} 
				else
				{ 
					System.out.println("Failed to move the file"); 
				}


				// Step -1 : Read input CSV file in Java /

				String inputCSVFile = movedCSVPath+csvfilename;
				CSVReader reader = new CSVReader(new FileReader(inputCSVFile));
				System.out.println("in convert csv to pdf mode.");
				// Variables to loop through the CSV File  
				String [] nextLine;             
				int lnNum = 0;   
				//Step-2: Initialize PDF documents - logical objects 
				com.itextpdf.text.Document my_pdf_data = new com.itextpdf.text.Document(PageSize.A2);
				//PDPage page = new PDPage(PD);
				
				System.out.println("create pdf object..");
				try  {
					
					
					PdfWriter.getInstance((com.itextpdf.text.Document) my_pdf_data, new FileOutputStream((movedCSVPath+pdffilename).trim()));
					System.out.println("inside pdf convert..");
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try { 
					my_pdf_data.open();        
					System.out.println("open pdf file.");
					PdfPTable my_first_table = new PdfPTable(8);
					//Cell c1= new Cell();
					PdfPCell table_cell = null;
					System.out.println("before while loop");
					PdfPCell cell1 = new PdfPCell(new Paragraph("Date"));
					PdfPCell cell2 = new PdfPCell(new Paragraph("Time"));
				    PdfPCell cell3 = new PdfPCell(new Paragraph("Brand"));
					PdfPCell cell4 = new PdfPCell(new Paragraph("Product"));
					PdfPCell cell5 = new PdfPCell(new Paragraph("Categories"));
					PdfPCell cell6 = new PdfPCell(new Paragraph("Language"));
					PdfPCell cell7 = new PdfPCell(new Paragraph("Genre"));
					PdfPCell cell8 = new PdfPCell(new Paragraph("Channel"));
					cell1.setBackgroundColor(BaseColor.GRAY);
					cell2.setBackgroundColor(BaseColor.GRAY);
				 	cell3.setBackgroundColor(BaseColor.GRAY);
					cell4.setBackgroundColor(BaseColor.GRAY);
					cell5.setBackgroundColor(BaseColor.GRAY);
					cell6.setBackgroundColor(BaseColor.GRAY);
					cell7.setBackgroundColor(BaseColor.GRAY);
					cell8.setBackgroundColor(BaseColor.GRAY);
					my_first_table.addCell(cell1);
					my_first_table.addCell(cell2);
					my_first_table.addCell(cell3);
					my_first_table.addCell(cell4);
					my_first_table.addCell(cell5);
					my_first_table.addCell(cell6);
					my_first_table.addCell(cell7);
					my_first_table.addCell(cell8);
					
					while ((nextLine = reader.readNext()) != null) {
						lnNum++;        
						my_first_table.addCell(nextLine[1]);
						my_first_table.addCell(nextLine[2]);
					    my_first_table.addCell(nextLine[6]);
						my_first_table.addCell(nextLine[7]);
						my_first_table.addCell(nextLine[9]);
						my_first_table.addCell(nextLine[10]);
						my_first_table.addCell(nextLine[11]);
						my_first_table.addCell(nextLine[12]);
					}

					System.out.println("after while loop.");
					// Step -4: Attach table to PDF and close the document 
					my_first_table.deleteRow(1); 
					System.out.println("before create pdf file method.");
				
					my_pdf_data.add(my_first_table);
					my_pdf_data.close();
					System.out.println("after create pdf method..");
				} 
				
				catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch(Exception e )  {
					e.printStackTrace();
				}

				reader.close();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("file moved exception found.");
				e1.printStackTrace();
			} 


			File pdffile = null;
			File csvFile = null;
		
			try { 
				pdffile = new File((filePath+pdffilename).trim());
				System.out.println("download pdf file name"+pdffile);
				csvFile = new File(filePath+csvfilename );
				System.out.println("csv file name before delete"+csvFile);
				InputStream inputStream = new FileInputStream(pdffile);
				response.setContentType("application/force-download");
				response.setHeader("Content-Disposition", "attachment; filename="+pdffilename); 
				IOUtils.copy(inputStream, response.getOutputStream());
				response.flushBuffer();
				inputStream.close();
				System.out.println("file download complete..");
				util.delete(pdffile);
				util.delete(csvFile);
				return ResponseEntity.ok().body("");
			} catch (Exception e) { 
				System.out.println(e);
				e.printStackTrace(); 
				return ResponseEntity.ok().body("500");
			}

			finally 
			{
				System.out.println("finaly block");
				util.delete(pdffile);
				util.delete(csvFile);
			}



		}
		return null;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	//................................................default 7 days filter...............................................

	@RequestMapping(value="/productDefautlFilter/{fromdate}/{todate}",method=RequestMethod.POST)
	public @ResponseBody List<AllChannelDetails>  defaultProductfilter(@PathVariable("fromdate") String fromdate, @PathVariable("todate") String todate
			) { 

		System.out.println("start date...."+fromdate+"...end date..."+todate);
		List<AllChannelDetails> list=new ArrayList<AllChannelDetails>();
		list=exportdata.defaultProduct(fromdate,todate);
		//System.out.println(" after all filter option method");
		return list;
	}

	@RequestMapping(value="/categoryDefaultFilter/{fromdate}/{todate}",method=RequestMethod.POST)
	public @ResponseBody List<AllChannelDetails>  categoryDefaultFilter(@PathVariable("fromdate") String fromdate, @PathVariable("todate") String todate
			) { 

		System.out.println("start date...."+fromdate+"...end date..."+todate);
		List<AllChannelDetails> list=new ArrayList<AllChannelDetails>();
		list=exportdata.defaultCategory(fromdate,todate);
		//System.out.println(" after all filter option method");
		return list;
	}
	

	@RequestMapping(value="/brandDefautlFilter/{fromdate}/{todate}",method=RequestMethod.POST)
	public @ResponseBody List<AllChannelDetails>  defaultBrandfilter(@PathVariable("fromdate") String fromdate, @PathVariable("todate") String todate
			) { 

		System.out.println("start date...."+fromdate+"...end date..."+todate);
		List<AllChannelDetails> list=new ArrayList<AllChannelDetails>();
		list=exportdata.defaultbrand(fromdate,todate);
		//System.out.println(" after all filter option method");
		return list;
	}

	@RequestMapping(value="/genreDefautlFilter/{fromdate}/{todate}",method=RequestMethod.POST)
	public @ResponseBody List<AllChannelDetails>  defaultGenrefilter(@PathVariable("fromdate") String fromdate, @PathVariable("todate") String todate
			) { 

		System.out.println("start date...."+fromdate+"...end date..."+todate);
		List<AllChannelDetails> list=new ArrayList<AllChannelDetails>();
		list=exportdata.defaultgenre(fromdate,todate);
		//System.out.println(" after all filter option method");
		return list;
	}

	@RequestMapping(value="/languageDefautlFilter/{fromdate}/{todate}",method=RequestMethod.POST)
	public @ResponseBody List<AllChannelDetails>  defaultLanguagefilter(@PathVariable("fromdate") String fromdate, @PathVariable("todate") String todate
			) { 

		System.out.println("start date...."+fromdate+"...end date..."+todate);
		List<AllChannelDetails> list=new ArrayList<AllChannelDetails>();
		list=exportdata.defaultLanguage(fromdate,todate);
		//System.out.println(" after all filter option method");
		return list;
	}

}

