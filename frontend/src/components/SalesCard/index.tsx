import { useEffect, useState } from 'react';
import DatePicker from 'react-datepicker';
import { api } from '../../service/api';
import { TypeSale } from '../../types/TypeSale';
import { FormatDate } from '../../utils/FormatDate';

import { NotificationButton } from '../NotificationButton';
import './styles.css';

const SalesCard = () => {
  const [data, setData] = useState<TypeSale[]>([]);
  console.log(data);
  const min = new Date(new Date().setDate(new Date().getDate() - 365));
  const max = new Date();
  const [minDate, setMinDate] = useState(min);
  const [maxDate, setMaxDate] = useState(max);

  useEffect(() => {
    (async () => {
      await api(
        `/sales?page=0&size=6&minDate=2021-11-01&maxDate=2021-12-31`
      ).then(response => {
        setData(response.data.content);
      });
    })();
  }, []);

  return (
    <div className='dsmeta-card'>
      <h2 className='dsmeta-sales-title'>Vendas</h2>
      <div>
        <div className='dsmeta-form-control-container'>
          <DatePicker
            selected={minDate}
            onChange={(date: Date) => setMinDate(date)}
            className='dsmeta-form-control'
            dateFormat='dd/MM/yyyy'
            isClearable
            showTimeSelect
            selectsStart
            startDate={minDate}
            endDate={maxDate}
          />
        </div>
        <div className='dsmeta-form-control-container'>
          <DatePicker
            selected={maxDate}
            onChange={(date: Date) => setMaxDate(date)}
            className='dsmeta-form-control'
            dateFormat='dd/MM/yyyy'
            isClearable
            selectsEnd
            startDate={maxDate}
            endDate={maxDate}
          />
        </div>
      </div>
      <div>
        <table className='dsmeta-sales-table'>
          <thead>
            <tr>
              <th className='show992'>ID</th>
              <th className='show576'>Data</th>
              <th>Vendedor</th>
              <th className='show992'>Visitas</th>
              <th className='show992'>Vendas</th>
              <th>Total</th>
              <th>Notificar</th>
            </tr>
          </thead>
          <tbody>
            {data?.map(value => {
              return (
                <tr key={value.id}>
                  <td className='show992'>{value.id}</td>
                  <td className='show576'>{FormatDate(value.date)}</td>
                  <td>{value.sellerName}</td>
                  <td className='show992'>{value.visited}</td>
                  <td className='show992'>{value.deals}</td>
                  <td>R$ {value.amount.toFixed(2)}</td>
                  <td>
                    <div className='dsmeta-red-btn-container'>
                      <div className='dsmeta-red-btn'>
                        <NotificationButton />
                      </div>
                    </div>
                  </td>
                </tr>
              );
            })}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export { SalesCard };
