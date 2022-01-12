## Batch에 관한 메타 데이터 테이블 설명

<p>테이블 설명 정리 문서입니다.</p>
<p>스키마 파일은 org.springframework.batch:spring-batch-core 디펜던시에서 확인할 수 있습니다.</p>
<br>

![schema_image](./image/spring_batch_table_schema.png)

### BATCH_JOB_INSTANCE

<p>Job이 실행되며 생성되는 최상위 계층의 테이블</p>
<p>job_name과 job_key를 기준으로 하나의 row가 생성됨</p>
<p>같은 job_name과 job_key가 저장될 수 없음</p>
<p>job_key는 BATCH_JOB_EXECUTION_PARAMS에 저장되는 Parameter를 나열해 암호화하여 저장</p>
<p>JobInstance : BATCH_JOB_INSTANCE 테이블과 매핑</p>

<br>

### BATCH_JOB_EXECUTION

<p>Job이 실행되는 동안 시작/종료 시간, job 상태 등을 관리</p>
<p>JobExecution : BATCH_JOB_EXECUTION 테이블과 매핑</p>

<br>

### BATCH_JOB_EXECUTION_PARAMS

<p>Job을 실행하기 위해 주입된 파라미터 정보를 저장</p>
<p>JobParameters : BATCH_JOB_EXECUTION_PARAMS 테이블과 매핑</p>

<br>

### BATCH_JOB_EXECUTION_CONTEXT

<p>Job이 실행되며 공유해야할 데이터를 직렬화하여 저장</p>
<p>ExecutionContext : BATCH_JOB_EXECUTION_CONTEXT 테이블과 매핑</p>

<br>

### BATCH_STEP_EXECUTION

<p>Step이 실행되는 동안 필요한 데이터 또는 실행된 결과 저장</p>
<p>StepExecution : BATCH_STEP_EXECUTION 테이블과 매핑</p>

<br>

### BATCH_STEP_EXECUTION_CONTEXT

<p>Step이 실행되며 공유해야할 데이터를 직렬화하여 저장</p>
<p>ExecutionContext : BATCH_STEP_EXECUTION_CONTEXT 테이블과 매핑</p>

