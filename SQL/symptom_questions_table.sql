-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 05, 2015 at 01:05 AM
-- Server version: 5.5.41-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `get_better`
--

-- --------------------------------------------------------

--
-- Table structure for table `symptom_questions_table`
--

CREATE TABLE IF NOT EXISTS `symptom_questions_table` (
  `question_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `symptom_id` int(11) unsigned NOT NULL,
  `action_needed` varchar(100) DEFAULT NULL,
  `english_question` varchar(255) NOT NULL,
  `tagalog_question` varchar(255) NOT NULL,
  `english_positive_response` varchar(20) NOT NULL DEFAULT 'Yes',
  `english_negative_response` varchar(20) NOT NULL DEFAULT 'No',
  `tagalog_positive_response` varchar(20) NOT NULL DEFAULT 'Oo',
  `tagalog_negative_response` varchar(20) NOT NULL DEFAULT 'Hindi',
  `not_applicable_response` varchar(10) NOT NULL DEFAULT 'N/A',
  PRIMARY KEY (`question_id`),
  KEY `symptom_id` (`symptom_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=93 ;

--
-- Dumping data for table `symptom_questions_table`
--

INSERT INTO `symptom_questions_table` (`question_id`, `symptom_id`, `action_needed`, `english_question`, `tagalog_question`, `english_positive_response`, `english_negative_response`, `tagalog_positive_response`, `tagalog_negative_response`, `not_applicable_response`) VALUES
(1, 1, NULL, 'Does the patient show signs of ear problem?', 'May pinapakita bang problema sa tenga ang pasyente?', 'Yes', 'No', 'Meron', 'Wala', 'N/A'),
(2, 1, NULL, 'Does the patient show signs of colds?', 'Sinisipon ba ang pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(3, 1, NULL, 'Does the patient show signs of sore throat?', 'Masakit ba ang lalamunan ng pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(4, 1, NULL, 'Does the patient show signs of cough?', 'Inuubo ba ang pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(5, 1, 'Check the skin of the patient', 'Does the patient show signs of rash, like measles?', 'May mga pantal ba ang balat ng pasyente na parang tigdas?', 'Yes', 'No', 'Meron', 'Wala', 'N/A'),
(6, 1, NULL, 'Does the patient show signs of pain when urinating?', 'Masakit ba kapag umiihi ang pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(7, 1, 'Check the skin of the patient', 'Does the patient show signs of any visible infections on the body?', 'Meron ba mga nakikitang impeksyon sa katawan ng pasyente?', 'Yes', 'No', 'Meron', 'Wala', 'N/A'),
(8, 1, NULL, 'Does the patient experience fever everyday for a week or more and came on gradually?', 'Nilalagnat ba ang pasyente araw-araw ng isang linggo o mahigit at pabalik-balik ang lagnat?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(9, 1, NULL, 'Does the fever of the patient responds to Paracetamol?\r\n', 'Tumatalab ba ang Paracetamol sa lagnat ng pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(10, 1, NULL, 'Does the fever of the patient never goes away or not intermittent?\r\n', 'Hindi ba nawawala ang lagnat ng pasyente at patuloy-tuloy?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(11, 1, NULL, 'Does the patient find it hard to sleep and has very poor appetite?\r\n', 'Mahirap ba makatulog ang pasyente at hindi masyadong nakain?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(12, 1, 'Check for the pulse rate of the patient', 'Does the pulse of the patient slower than expected for fever?\r\n', 'Mabagal ba ang pulso ng pasyente para sa lagnat?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(13, 1, NULL, 'Does the patient think slow or is easily confused?\r\n', 'Madali bang malito ang pasyente o mabagal magisip?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(14, 1, NULL, 'Does the fever and pain came on suddenly?\r\n', 'Bigla na lang ba nagkaron ng lagnat ang pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(15, 1, NULL, 'Does the patient experience very painful eyes or back?\r\n', 'Masakit ba ang mata o ang likod ng pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(16, 1, NULL, 'Does the patient experience petichial or fleeting rash, like little blood spots, or quickly fading itchy rash?\r\n', 'Nagkakaron ba ang pasyente ng mga pantal na madaling nawawala?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(17, 1, NULL, 'Is the patient very weak?\r\n', 'Nanghihina ba sobra ang pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(18, 1, NULL, 'Does the patient experience bleeding in feces?\r\n', 'Meron bang dugo kapag nagdudumi ang pasyente?', 'Yes', 'No', 'Meron', 'Wala', 'N/A'),
(19, 1, NULL, 'Does the patient show signs of red eyes?\r\n', 'Namumula ba ang mga mata ng pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(20, 1, NULL, 'Does the patient show signs of a flat rash beginning behind ears, red, to brown?\r\n', 'Meron bang pantal ang pasyente sa likod ng tenga na kulay pula?', 'Yes', 'No', 'Meron', 'Wala', 'N/A'),
(21, 2, 'Count the number of times the patient breathes in one minute', 'For a child more than 1 year old, does the child breathe more than 40 times per minute?', 'Para sa bata na ang edad ay isa pataas, ang paghinga ba ng bata ay more than 40 times sa isang minuto?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(22, 2, 'Count the number of times the patient breathes in one minute', 'For a child less than 1 year old, does the child breathe more than 50 times per minute?', 'Para sa bata na ang edad ay isa pababa, ang paghinga ba ng bata ay more than 50 times sa isang minuto?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(23, 2, 'If yes, take a video of the child''s face.', 'Does the child has retractions or nose flaring?\r\n', 'Lumalaki ba ang butas ng ilong ng bata kapag humihinga?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(24, 2, 'Put your ear or a stethoscope, on the back of the patient''s chest', 'Is there a wheezing sound when the patient breathes?', 'May tunog ba na parang sipol kapag humihinga ang pasyente?', 'Yes', 'No', 'Meron', 'Wala', 'N/A'),
(25, 2, NULL, 'Is there any sound when the patient is breathing?', 'Meron bang tunog kapag humihinga ang pasyente?', 'Yes', 'No', 'Meron', 'Wala', 'N/A'),
(26, 2, 'Count the number of times the patient breathes in one minute', 'Is the patient breathing very fast (30/min)?', 'Masyado bang mabilis ang paghinga ng pasyente(30/min)?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(27, 2, 'Put your ear or stethoscope on the back of the patient''s chest', 'Is there a sound like water gurgling or rattling when the patient breathes?', 'May tunog ba na parang may tubig kapag humihinga ang pasyente?', 'Yes', 'No', 'Meron', 'Wala', 'N/A'),
(28, 2, NULL, 'Does the patient cough up blood?', 'May dugo ba kapag umuubo ang pasyente?', 'Yes', 'No', 'Meron', 'Wala', 'N/A'),
(29, 2, NULL, 'Is the patient been coughing for more than one month?', 'Mahigit isang buwan na ba ang pagubo ng pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(30, 2, NULL, 'Did the patient grew thin in the last month?', 'Nangayayat ba ang pasyente sa nagdaang buwan?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(31, 2, NULL, 'Does the patient have slight fevers frequently especially at night?', 'Madalas bang magkaroon ng bahagyang lagnat ang pasyente lalo na sa gabi?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(32, 2, NULL, 'Does the patient experience chest pain?', 'Masakit ba ang dibdib ng pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(33, 2, NULL, 'If the patient is a child, did the patient just recover from measles but not regaining strength or weight, and continues to cough?', 'Kung ang pasyente ay bata, kagagaling lang ba sa sakit na tigdas ang bata ngunit hindi pa nanunumbalik ang lakas o timabang, at patuloy pa din ang pag ubo?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(34, 2, NULL, 'If the patient is a child, does the child have a lymph node at the neck or the upper clavicle area?', 'Kung ang pasyente ay bata, meron bang lymph node ang bata sa kanyang leeg?', 'Yes', 'No', 'Meron', 'Wala', 'N/A'),
(35, 3, NULL, 'Does the patient have stomach pain?', 'Ang pasyente ba ay nakararanas ng sakit sa tiyan?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(37, 3, NULL, 'Is the stomach pain of the patient steady?', 'Ang sakit ng tiyan ba ng pasyente ay hindi nawawala?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(38, 3, NULL, 'Is the pain on the lower right side of the patient''s abdomen?', 'Ang sakit ba na nararamdaman ng pasyente ay nasa ibabang-kanan ng tiyan?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(39, 3, NULL, 'Did the patient vomit?', 'Sumuka ba ang pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(40, 3, 'Ask the patient to lie down and listen to his abdomen with a stethoscope for three whole minutes.', 'Is there any bowel sounds (tinkling, gurgling) in the patient''s stomach?', 'Meron bang tunog na parang may tubig sa tiyan ng pasyente?', 'Yes', 'No', 'Meron', 'Wala', 'N/A'),
(41, 3, 'Press on the abdomen a little bit in all four parts.', 'Is the patient''s stomach pain only painful in the lower right part, not other places?', 'Ang sakit ba na nararamdaman ng pasyente sa kanyang tiyan ay nasa ibabang-kanan lang at wala sa ibang lugar?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(42, 3, NULL, 'Is the patient''s stomach pain hurt mostly high up, near under the ribs?', 'Ang sakit ba na nararamdaman ng pasyente ay nasa bandang itaas ng tiyan malapit sa baba ng tadyang?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(43, 3, NULL, 'Does the patient''s stomach hurt mostly when hungry?', 'Ang tiyan ba ng pasyente ay masakit lagi kapag gutom?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(44, 3, NULL, 'Does the patient''s stool have blood?', 'Meron bang dugo kapag dumudumi ang pasyente?', 'Yes', 'No', 'Meron', 'Wala', 'N/A'),
(45, 3, NULL, 'Does the patient''s stool contain mucous?', 'Meron bang myukus kapag dumudumi ang pasyente?', 'Yes', 'No', 'Meron', 'Wala', 'N/A'),
(46, 3, NULL, 'If patient is a child, Has the child passed worms in the last few weeks?', 'Kung ang pasyente ay bata, nakapasa ba ang bata sa "worms" sa nakaraang linggo?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(47, 3, NULL, 'If patient is a child, has the child experience waking up at night with itchy anus and mild stomach pains?', 'Kung ang pasyente ay bata, nagigising ba ang bata sa gabi na makati ang puwit at masakit ang tiyan?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(48, 3, NULL, 'If the patient is a child, does the child had worm medicine in the last three months?', 'Kung ang pasyente ay bata, napurga na ba ang bata nitong nakaraan na tatlong buwan?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(49, 3, NULL, 'Does the patient experience pain when urinating?', 'Masakit ba kapag umiihi ang pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(50, 3, NULL, 'Does the patient urinate more frequently?', 'Madalas bang umihi ang pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(51, 4, NULL, 'Has the patient had diarrhea more than three times today?', 'Ang pasyente ba ay nagdudumi ng mahigit sa tatlong beses ngayong araw?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(52, 4, NULL, 'Does the patient have watery stools?', 'Matubig ba ang pagdudumi ng pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(53, 4, NULL, 'Is the patient very sleepy or tired?', 'Inaantok ba o masyadong pagod ang pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(54, 4, NULL, 'Does the patient cannot drink (breastfeed if baby)?', 'Ang pasyente ba ay hindi umiinom (ayaw mag dede kapag sanggol)?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(55, 4, 'Pinch the skin of the patient lightly. ', 'Does the skin of the patient do not return to it''s place in 2 seconds?', 'Hindi ba bumalik sa lugar ang balat ng pasyente pagkalipas ng dalawang segundo?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(56, 4, NULL, 'Is the patient irritable?', 'Mabilis ba mairita ang pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(57, 4, NULL, 'Is the patient very thirsty?', 'Uhaw na uhaw ba ang pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(58, 4, NULL, 'Is the patient always asking for water?', 'Parati ba humihingi ng tubig ang pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(59, 4, NULL, 'Is there a lot of pain when the patient have diarrhea?', 'Nakakaranas ba ng sobrang sakit kapag dumudumi ang pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(60, 5, NULL, 'Does the patient have ear problems?', 'May problema ba sa tenga ng pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(61, 5, NULL, 'Is the patient''s ear painful?', 'Masakit ba ang tenga ng pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(62, 5, NULL, 'If the patient is a baby, is the baby pulling always pulling his/her ears?', 'Kung ang pasyente ay sanggol, lagi bang hinihila ng sanggol ang kanyang tenga?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(63, 5, 'Ask this question gently and maybe ask this 2-3 different ways.', 'Is there any water coming out of the patient''s ear?', 'Meron bang tubig na lumalabas sa tenga ng pasyente?', 'Yes', 'No', 'Meron', 'Wala', 'N/A'),
(64, 5, NULL, 'If there is water coming out of the ear, how many days have the patient noticed it?', 'Kung may tubig na lumalabas sa sa tenga, ilang araw na napapansin ng pasyente ito?', '2 weeks or more', 'Less than 2 weeks', 'Mahigit 2 linggo', 'Wala pang 2 linggo', 'N/A'),
(65, 5, NULL, 'If there is water coming out of the ear, has the water coming out of the ear been on and off frequently in the past?', 'Kung may tubig na lumalabas sa tenga, madalas ba na pasulpot sulpot lang ito dati pa?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(66, 5, NULL, 'Is the ear of the patient painful and/or swollen around the ear, especially behind the ear?', 'Ang sakit ba na nararamdaman ng pasyente ay nasa paligid ng tenga lalo na sa likod ng tenga?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(67, 5, NULL, 'Is the ear of the patient only painful when the patient wiggle it?', 'Masakit ba ang tenga ng pasyente kapag ginagalaw niya ito?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(68, 5, NULL, 'Is this the first time the patient had problems with his/her ears? ', 'Ito ba ang unang beses magkaroon ng problema sa tenga ang pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(69, 6, NULL, 'Does the patient have a rash or other skin problem?', 'Meron bang problema sa balat ng pasyente?', 'Yes', 'No', 'Meron', 'Wala', 'N/A'),
(70, 6, NULL, 'Are there any scaly areas in the skin of the patient that looked like it can be peeled off?', 'Meron bang parang kaliskis sa balat ng pasyente na pwedeng balatan?', 'Yes', 'No', 'Meron', 'Wala', 'N/A'),
(71, 6, NULL, 'Is there any dried yellowish pus or other material around the skin of the patient?', 'Meron bang natuyong nana sa balat ng pasyente?', 'Yes', 'No', 'Meron', 'Wala', 'N/A'),
(72, 6, NULL, 'Is there a swollen area in the skin of the patient?', 'Meron bang parte sa balat ng pasyente na namamaga?', 'Yes', 'No', 'Meron', 'Wala', 'N/A'),
(73, 6, NULL, 'Is the area of the patient''s skin red?', 'Namumula ba ang balat ng pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(74, 6, NULL, 'Is the infected area on the skin of the patient hotter than other areas?', 'Ang bahagi ng balat ng pasyente na may problema ay mainit kumpara ibang bahagi?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(75, 6, NULL, 'Is the skin problem of the patient itchy?', 'Ang lokasyon ba ng pantal ay nasa mga tagong lugar tulad ng bewang o sa gitna ng mga daliri?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(76, 6, NULL, 'Is the skin problem of the patient very itchy?', 'Sobrang kati ba ng problema sa balat ng pasyente?', 'Yes', 'Not Very', 'Oo', 'Hindi', 'N/A'),
(77, 6, NULL, 'Is the skin of the patient slightly rough and itchy?', 'Ang balat ba ng pasyente ay medyo magaspang at makati?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(78, 6, NULL, 'Even if not very itchy, is the skin of the patient slightly rough and turning white?', 'Kahit na hindi sobrang makati, ang balat ba ng pasyente ay medyo magaspang at nagiging kulay puti?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(79, 6, NULL, 'Is the itchy area of the patient''s skin smooth?', 'Makinis ba ang makating bahagi ng balat ng pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(80, 6, NULL, 'Does the skin of the patient gets red easily if its scratched?', 'Madali bang mamula ang balat ng pasyente kapag kinamot?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(81, 6, NULL, 'Is the itchy area of the patient''s skin slightly raised (hives)?', 'Ang makating bahagi ba ng balat ng pasyente ay medyo nakaangat?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(82, 6, NULL, 'Does the patient have a fever with the rash?', 'Ang pasyente ba ay may lagnat kasama ang pantal sa balat?', 'Yes', 'No', 'Meron', 'Wala', 'N/A'),
(83, 6, NULL, 'Does the rash of the patient have little pockets of water?', 'Ang pantal ba ng pasyente ay may laman ng tubig sa loob?', 'Yes', 'No', 'Meron', 'Wala', 'N/A'),
(84, 7, NULL, 'Does the patient have an eye problem?', 'May problema ba sa mata ng pasyente?', 'Yes', 'No', 'Meron', 'Wala', 'N/A'),
(85, 7, NULL, 'Did the patient suddenly have a change in his/her vision?', 'Nagkaroon ba ng pagbabago sa paningin ng pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(86, 7, NULL, 'Is the eye of the patient painful without any clear reason?', 'Masakit ba ang mga mata ng pasyente ng walang rason?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(87, 7, NULL, 'If the eye of the patient is red, is the redness near the colored part?', 'Kung mapula ang mata ng pasyente, ang pagkapula ba ay malapit sa makulay na bahagi?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(88, 7, NULL, 'Is the eye of the patient swollen or like it''s protruding out?', 'Namamaga ba ang mga mata ng pasyente o parang lumuluwa?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(89, 7, NULL, 'Does the patient feel like there is something in the eye that doesn''t come out even though the tears have washed it?', 'Nararamdaman ba ng pasyente na parang may bagay sa kanyang mata na hindi matanggal kahit malinis ng luha?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A'),
(90, 7, NULL, 'Is there pus in the patient''s eye, or the eyes are red but the redness doesn''t touch the colored part?', 'Meron bang nana sa mata ng pasyente, o namumula ito pero ang pagkapula ay malayo sa makulay na bahagi ng mata?', 'Yes', 'No', 'Meron', 'Wala', 'N/A'),
(91, 7, NULL, 'Is there a foreign body on the eye of the patient?', 'Meron bang nakikitang bagay na nasa mata ng pasyente?', 'Yes', 'No', 'Meron', 'Wala', 'N/A'),
(92, 7, NULL, 'If patient is an adult and the eye is not painful, does the center black part of the patient''s eye hazy?', 'Kung ang pasyente ay matanda na at hindi masyado masakit ang mata, malabo ba o hindi masyadong maitim ang itim na bahagi sa gitna ng mata ng pasyente?', 'Yes', 'No', 'Oo', 'Hindi', 'N/A');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
