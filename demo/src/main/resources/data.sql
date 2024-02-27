INSERT INTO Claim (id, hospital, patient_name, claim_summary, claim_description) VALUES (1, 'Apollo Hospital', 'Govind Sharma', 'Diagnostic Services', 'X-ray, chest, single view MRI, CT Scan, abdomen and pelvis');
INSERT INTO Claim (id, hospital, patient_name, claim_summary, claim_description) VALUES (2, 'Tata Memorial Hospital', 'Shweta Singh', 'Imaging Studies', 'Ultrasound, abdomen Mammogram, Ecocardiogram, Screening');
INSERT INTO Claim (id, hospital, patient_name, claim_summary, claim_description) VALUES (3, 'Apollo Hospital', 'Sameer Kumar', 'Laboratory tests', 'Complete Blood count (CBC), comprehensive metabolic panel (CMP)');
INSERT INTO Claim (id, hospital, patient_name, claim_summary, claim_description) VALUES (4, 'Nanavati Hospital', 'Raj Khosla', 'Procedures', 'Colonoscopy, esophageal dilation, Laparosscopy');
INSERT INTO Claim (id, hospital, patient_name, claim_summary, claim_description) VALUES (5, 'Breach Candy Hospital Trust', 'Manu Sharma', 'Surgical procedures', 'Appendectomy, Cholecystectomy');

INSERT INTO Underwriting (id, age, gender, bmi, occupation, medical_history, risk_meter, rate_meter, approved) VALUES (1, 30, 'Male', 25.5, 'Engineer', 'In Good Health', 'low', 2301, true);
INSERT INTO Underwriting (id, age, gender, bmi, occupation, medical_history, risk_meter, rate_meter, approved) VALUES (2, 25, 'Female', 22.0, 'Doctor', 'In Good Health', 'low', 2190, true);
INSERT INTO Underwriting (id, age, gender, bmi, occupation, medical_history, risk_meter, rate_meter, approved) VALUES (3, 35, 'Male', 28.3, 'Teacher', 'Hypertension', 'high', 4000, false);
INSERT INTO Underwriting (id, age, gender, bmi, occupation, medical_history, risk_meter, rate_meter, approved) VALUES (4, 28, 'Female', 26.8, 'Software Developer', 'Respiratory problems', 'medium', 3120, true);
INSERT INTO Underwriting (id, age, gender, bmi, occupation, medical_history, risk_meter, rate_meter, approved) VALUES (5, 40, 'Male', 30.1, 'Nurse', 'Diabetes, Cardiovascular disease', 'high', 3330, false);

Insert INTO Bill (claim_id, bill_id, bill_date, bill_description, bill_amount) values (1, 1, '2023-01-02', 'Consultation charges', 200 );
Insert INTO Bill (claim_id, bill_id, bill_date, bill_description, bill_amount) values (1, 2, '2023-01-02', 'ECG charges', 200 );
Insert INTO Bill (claim_id, bill_id, bill_date, bill_description, bill_amount) values (2, 3, '2023-01-03', 'Consultation charges', 200 );
Insert INTO Bill (claim_id, bill_id, bill_date, bill_description, bill_amount) values (2, 4, '2023-01-04', 'ECG charges', 200 );
Insert INTO Bill (claim_id, bill_id, bill_date, bill_description, bill_amount) values (3, 5, '2023-01-03', 'Consultation charges', 200 );
Insert INTO Bill (claim_id, bill_id, bill_date, bill_description, bill_amount) values (3, 6, '2023-01-04', 'ECG charges', 200 );
Insert INTO Bill (claim_id, bill_id, bill_date, bill_description, bill_amount) values (3, 7, '2023-01-04', 'X-Ray charges', 400 );
Insert INTO Bill (claim_id, bill_id, bill_date, bill_description, bill_amount) values (3, 8, '2023-01-05', 'Sonography charges', 500 );
